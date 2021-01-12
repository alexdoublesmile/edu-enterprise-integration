package com.plohoy.enterpriseservice.service.storeservice.impl;

import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.entity.VipipInfo;
import com.plohoy.enterpriseservice.repository.VipipInfoRepository;

/**
 * Vipip Store Service implementation.
 * Sets Vipip implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class VipipStoreService
        extends AbstractStoreService<VipipInfo, VipipInfoRepository> {

    /**
     * Instantiates a new Vipip store service.
     * And sets Vipip Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository Vipip Repository
     */
    public VipipStoreService(VipipInfoRepository repository) {
        super(repository);
    }

    @Override
    protected VipipInfo getNewEntity() {
        return new VipipInfo();
    }
}