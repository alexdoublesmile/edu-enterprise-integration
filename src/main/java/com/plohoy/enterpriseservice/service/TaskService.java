package com.plohoy.enterpriseservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import com.plohoy.enterpriseservice.binding.DelaySource;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.RequestTask;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.util.PathBuilder;
import com.plohoy.enterpriseservice.util.RestHelper;
import com.plohoy.enterpriseservice.util.StoreServiceFactory;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

/**
 * Service for executing Request Task from queue
 */
@Slf4j
@Service
@EnableBinding({Sink.class, DelaySource.class})
public class TaskService {
    @Autowired private StoreServiceFactory storeServiceFactory;
    @Autowired private PathBuilder pathBuilder;
    @Autowired private RestHelper restHelper;

    @Value("${response.attempt.limit}")
    private Integer attemptLimit;

    private final DelaySource delaySource;

    /**
     * Instantiates a new Task Service with proper output Source class for repeated sending to queue.
     *
     * @param delaySource the delay source
     */
    public TaskService(DelaySource delaySource) {
        this.delaySource = delaySource;
    }

    /**
     * - Gets Request task from queue and increase attempts of it's returns<br>
     * - Then try to execute Request task<br>
     * - If success, response from Ext Service sending to current Store Service<br>
     * - If not success, Request task is sending back to the queue(if there are attempts of returns)
     *
     * @see AbstractStoreService
     * @see BaseStrategy
     * @param message the message
     * @throws JsonProcessingException the json processing exception
     */
    @StreamListener(target = Sink.INPUT)
    public void handleRequestTask(Message<Object> message)
            throws JsonProcessingException {
        log.info("Processing task: {}", message.getPayload().toString());

        RequestTask task = getRequestTaskFromMessage(message);
        task.increaseAttempts();
        log.info("Attempt for {}: {}",
                task.getRequestType(),
                task.getAttempts());

        try {
            ResponseEntity<? extends ResponseDto> response =
                    restHelper.getResponse(
                            pathBuilder.getFindInfoByIdUrl(
                                            task.getFindIdPathTemplate(),
                                            task.getClientId()),
                            task.getResponseDtoClass());
            log.info("Получен ответ: " + response.getBody());

            storeServiceFactory
                    .getStoreService(task.getRequestType())
                    .saveInfoFromExtService(
                            response.getBody(),
                            task.getId());

        } catch (HttpClientErrorException.NotFound e) {
            log.info("Ответ не найден: {}", e.getMessage());

            if (task.getAttempts() >= attemptLimit) {
                log.info("Превышено допустимое количество попыток");
                return;
            }
            log.info("Retrying");

            delaySource.output().send(
                    MessageBuilder.withPayload(task)
                            .build());
        }
    }

    private RequestTask getRequestTaskFromMessage(Message<Object> message)
            throws JsonProcessingException {
        return new ObjectMapper()
                .readValue(
                        message.getPayload().toString(),
                        RequestTask.class);
    }
}
