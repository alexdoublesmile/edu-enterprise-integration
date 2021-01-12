package com.plohoy.enterpriseservice.service.storeservice.impl;

import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.entity.VipulInfo;
import com.plohoy.enterpriseservice.repository.VipulInfoRepository;

/**
 * Vipul Store Service implementation.
 * Sets Vipul implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class VipulStoreService
        extends AbstractStoreService<VipulInfo, VipulInfoRepository> {

    /**
     * Instantiates a new Vipul store service.
     * And sets Vipul Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository Vipul Repository
     */
    public VipulStoreService(VipulInfoRepository repository) {
        super(repository);
    }

    @Override
    protected VipulInfo getNewEntity() {
        return new VipulInfo();
    }
}