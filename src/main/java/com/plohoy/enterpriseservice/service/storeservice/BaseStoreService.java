package com.plohoy.enterpriseservice.service.storeservice;

import com.plohoy.enterpriseservice.entity.BaseJsonbEntity;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestTask;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import java.util.Optional;

/**
 * Base Store Service Interface.<br>
 * Is implemented by AbstractStoreService
 *
 * @see AbstractStoreService
 * @param <T> Entity type parameter
 */
public interface BaseStoreService<T extends BaseJsonbEntity> {

    /**
     * Finds by INN proper entity by repositoty & gets it in Optional wrapper.
     * If cache is expired - updates entity & synchronizes with SMEV
     *
     * @param task Smev Request Task
     * @return Optional wrapper with current entity from DB
     */
    Optional<T> findByInn(SmevRequestTask task);

    /**
     * Saves or updates responseDTO info to DB by INN.
     * @see BaseStrategy
     *
     * @param responseDto the response dto
     * @return saved Entity ID
     */
    String saveInfoFromSmev(ResponseDto responseDto, String inn);

//    T createRandomByInn(SmevRequestTask task);
}
