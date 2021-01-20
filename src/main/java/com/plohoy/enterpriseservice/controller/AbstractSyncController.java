package com.plohoy.enterpriseservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.plohoy.enterpriseservice.entity.BaseJsonBinaryEntity;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.RequestTask;
import com.plohoy.enterpriseservice.service.SyncService;
import com.plohoy.enterpriseservice.util.StoreServiceFactory;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import java.util.concurrent.CompletableFuture;

/**
 * Base Abstract Controller.
 * All parameter types sets by current Controller implementation
 *
 * @see BaseSyncController
 * @param <T> proper Entity type parameter
 * @param <S> proper Strategy type parameter
 */
@Slf4j
@Getter
@RestController
public abstract class AbstractSyncController<
        T extends BaseJsonBinaryEntity,
        S extends BaseStrategy>
            implements BaseSyncController<T> {
    @Autowired private SyncService syncService;
    @Autowired private StoreServiceFactory storeServiceFactory;

    private final S strategy;
    /**
     * Gets from current Controller implementation proper Strategy and sets it to class parameters.
     *
     * @see BaseStrategy
     * @param strategy proper Strategy
     */
    public AbstractSyncController(S strategy) {
        this.strategy = strategy;
    }

    @Operation(summary = "Получение сведений")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ответ найден"),
            @ApiResponse(responseCode = "404", description = "Не найдено сведений"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/{id}")
    @Override public ResponseDto getInfo(
            @Parameter(required = true, example = "01234567")
            @PathVariable String id) {
        return storeServiceFactory.getStoreService(strategy.getRequestType())
                .findByid(getTaskByid(id))
                .orElseGet(() -> {
                    syncService.synchronize(getTaskByid(id));
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND);
                })
                .getInfo();
    }

    @Operation(summary = "Отправка запроса на синхронизацию сведений")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ответ найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PostMapping("/sync")
    @Override public CompletableFuture<String> synchronize(
            @Parameter(required = true, example = "01234567")
            @RequestParam String id) {

        return syncService.synchronize(getTaskByid(id));
    }

    private RequestTask getTaskByid(String id) {
        return RequestTask.builder()
            .id(id)
            .requestPath(strategy.getRequestPath())
            .findIdPathTemplate(strategy.getFindIdPathTemplate())
            .requestType(strategy.getRequestType())
            .requestDto(strategy.getRequestDto(id))
            .responseDtoClass(strategy.getResponseDtoClass())
            .attempts(0)
            .build();
    }
//
//    @PostMapping("/test/create")
//    @Override public BaseJsonbEntity createRandomByid(@RequestParam String id) {
//        return storeServiceFactory
//                .getStoreService(strategy.getRequestType())
//                .createRandomByid(getTaskByid(id));
//    }
}
