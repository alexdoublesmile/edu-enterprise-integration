package com.plohoy.enterpriseservice.service.storeservice.impl;

import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.entity.NdipsrInfo;
import com.plohoy.enterpriseservice.repository.NdipsrInfoRepository;

/**
 * Ndipsr Store Service implementation.
 * Sets Ndipsr implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class NdipsrStoreService
        extends AbstractStoreService<NdipsrInfo, NdipsrInfoRepository> {

    /**
     * Instantiates a new Ndipsr store service.
     * And sets Ndipsr Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository Ndipsr Repository
     */
    public NdipsrStoreService(NdipsrInfoRepository repository) {
        super(repository);
    }

    @Override
    protected NdipsrInfo getNewEntity() {
        return new NdipsrInfo();
    }
}