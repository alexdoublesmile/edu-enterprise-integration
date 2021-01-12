package com.plohoy.enterpriseservice.service.storeservice.impl;

import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.entity.ZadorgInfo;
import com.plohoy.enterpriseservice.repository.ZadorgInfoRepository;

/**
 * Zadorg Store Service implementation.
 * Sets Zadorg implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class ZadorgStoreService
        extends AbstractStoreService<ZadorgInfo, ZadorgInfoRepository> {

    /**
     * Instantiates a new Zadorg store service.
     * And sets Zadorg Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository Zadorg Repository
     */
    public ZadorgStoreService(ZadorgInfoRepository repository) {
        super(repository);
    }

    @Override
    protected ZadorgInfo getNewEntity() {
        return new ZadorgInfo();
    }
}