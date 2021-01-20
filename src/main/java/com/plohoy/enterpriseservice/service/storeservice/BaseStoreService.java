package com.plohoy.enterpriseservice.service.storeservice;

import com.plohoy.enterpriseservice.entity.BaseJsonBinaryEntity;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.RequestTask;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import java.util.Optional;

/**
 * Base Store Service Interface.<br>
 * Is implemented by AbstractStoreService
 *
 * @see AbstractStoreService
 * @param <T> Entity type parameter
 */
public interface BaseStoreService<T extends BaseJsonBinaryEntity> {

    /**
     * Finds by id proper entity by repositoty & gets it in Optional wrapper.
     * If cache is expired - updates entity & synchronizes with Ext Service
     *
     * @param task Request Task
     * @return Optional wrapper with current entity from DB
     */
    Optional<T> findById(RequestTask task);

    /**
     * Saves or updates responseDTO info to DB by id.
     * @see BaseStrategy
     *
     * @param responseDto the response dto
     * @return saved Entity ID
     */
    String saveInfoFromExtService(ResponseDto responseDto, String id);

//    T createRandomById(RequestTask task);
}
