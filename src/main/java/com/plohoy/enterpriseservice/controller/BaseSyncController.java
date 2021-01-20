package com.plohoy.enterpriseservice.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.plohoy.enterpriseservice.entity.BaseJsonBinaryEntity;
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
public interface BaseSyncController<T extends BaseJsonBinaryEntity> {

    /**
     * Common GET method, which calls findByid method from Store Service with client id.
     * If it returns null throws an Exception & synchronizes with Ext Service
     * @see SyncService
     * @see TaskService
     * @param id id
     */
    @GetMapping
    ResponseDto getInfo(
            @Pattern(regexp = "^[0-9]+$", message = "id should contain digits only")
            @Length(min = 3, max = 24, message = "id can't contain less than {min} digits & more than {max} digits")
            @NotBlank(message = "id can't be empty")
            @PathVariable String id);

    /**
     * Common POST method, which calls synchronize method from Sync Service
     * with proper Request Task by input id
     * @see SyncService
     * @see TaskService
     *
     * @param id id
     */
    @PostMapping
    CompletableFuture<String> synchronize (
            @Pattern(regexp = "^[0-9]+$", message = "id should contain digits only")
            @Length(min = 3, max = 24, message = "id can't contain less than {min} digits & more than {max} digits")
            @NotBlank(message = "id can't be empty")
            @RequestParam String id);

//    @PostMapping BaseJsonbEntity createRandomByid(@RequestParam String id);
}
