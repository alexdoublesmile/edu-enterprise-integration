package com.plohoy.enterpriseservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestTask;
import com.plohoy.enterpriseservice.util.PathBuilder;

import java.util.concurrent.CompletableFuture;

/**
 * Service for getting request id from SMEV and sending SMEV task to queue.
 */
@Slf4j
@Service
@EnableBinding(Source.class)
public class SyncService {
    @Autowired private PathBuilder pathBuilder;
    @Autowired private RestTemplate restTemplate;
    private final Source source;

    /**
     * Instantiates a new Sync Service with proper output Source class for sending to queue.
     *
     * @param source the source
     */
    public SyncService(Source source) {
        this.source = source;
    }

    /**
     * Gets client request ID by sending to SMEV proper RequestDTO according current SMEV request task<br>
     * Then SMEV request task(with client request ID) sends to queue which shall send it on to the Task Service
     *
     * @see TaskService
     * @see BaseStrategy
     * @return future result
     */
    @Async public CompletableFuture<String> syncSmev(SmevRequestTask task) {
        log.info("Syncing {} for INN: {}",
                task.getRequestType(),
                task.getInn());

        String clientRequestId = restTemplate.postForObject(
                pathBuilder.getRequestUrl(task.getRequestPath()),
                task.getRequestDto(),
                String.class);
        log.info("Got clientId: {}", clientRequestId);

        log.info("Sending task {} to tasks queue", clientRequestId);
        sendSmevRequestTask(task, clientRequestId);

        return CompletableFuture.completedFuture(clientRequestId);
    }

    public void sendSmevRequestTask(SmevRequestTask task, String clientRequestId) {
        task.setClientId(clientRequestId);
        source.output().send(
                MessageBuilder
                        .withPayload(task)
                        .build());
    }
}
