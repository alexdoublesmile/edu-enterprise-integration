package com.plohoy.enterpriseservice.service.storeservice.impl;

import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.entity.ZvipulInfo;
import com.plohoy.enterpriseservice.repository.ZvipulInfoRepository;

/**
 * Zvipul Store Service implementation.
 * Sets Zvipul implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class ZvipulStoreService
        extends AbstractStoreService<ZvipulInfo, ZvipulInfoRepository> {

    /**
     * Instantiates a new Zvipul store service.
     * And sets Zvipul Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository Zvipul Repository
     */
    public ZvipulStoreService(ZvipulInfoRepository repository) {
        super(repository);
    }

    @Override
    protected ZvipulInfo getNewEntity() {
        return new ZvipulInfo();
    }
}
