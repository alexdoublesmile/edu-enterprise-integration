package com.plohoy.enterpriseservice.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.plohoy.enterpriseservice.entity.BaseJsonbEntity;
import com.plohoy.enterpriseservice.service.SyncService;
import com.plohoy.enterpriseservice.service.TaskService;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.concurrent.CompletableFuture;

/**
 * Base Controller Interface.
 * Is implemented by Base abstract controller
 *
 * @see AbstractSyncController
 * @param <T> Entity type parameter
 */
@Validated
public interface BaseSyncController<T extends BaseJsonbEntity> {

    /**
     * Common GET method, which calls findByInn method from Store Service with client INN.
     * If it returns null throws an Exception & synchronizes with SMEV
     * @see SyncService
     * @see TaskService
     * @param inn INN
     */
    @GetMapping
    ResponseDto getFnsInfo(
            @Pattern(regexp = "^[0-9]+$", message = "INN should contain digits only")
            @Length(min = 3, max = 24, message = "INN can't contain less than {min} digits & more than {max} digits")
            @NotBlank(message = "INN can't be empty")
            @PathVariable String inn);

    /**
     * Common POST method, which calls syncSmev method from Sync Service
     * with proper Smev Request Task by input INN
     * @see SyncService
     * @see TaskService
     *
     * @param inn INN
     */
    @PostMapping
    CompletableFuture<String> syncSmev (
            @Pattern(regexp = "^[0-9]+$", message = "INN should contain digits only")
            @Length(min = 3, max = 24, message = "INN can't contain less than {min} digits & more than {max} digits")
            @NotBlank(message = "INN can't be empty")
            @RequestParam String inn);

//    @PostMapping BaseJsonbEntity createRandomByInn(@RequestParam String inn);
}
