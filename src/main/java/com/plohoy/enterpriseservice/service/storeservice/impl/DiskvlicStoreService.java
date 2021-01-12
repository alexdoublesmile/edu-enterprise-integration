package com.plohoy.enterpriseservice.service.storeservice.impl;

import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.entity.DiskvlicInfo;
import com.plohoy.enterpriseservice.repository.DiskvlicInfoRepository;

/**
 * Diskvlic Store Service implementation.
 * Sets Diskvlic implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class DiskvlicStoreService
        extends AbstractStoreService<DiskvlicInfo, DiskvlicInfoRepository> {

    /**
     * Instantiates a new Diskvlic store service.
     * And sets Diskvlic Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository Diskvlic Repository
     */
    public DiskvlicStoreService(DiskvlicInfoRepository repository) {
        super(repository);
    }

    @Override
    protected DiskvlicInfo getNewEntity() {
        return new DiskvlicInfo();
    }
}