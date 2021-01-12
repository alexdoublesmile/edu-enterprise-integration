package com.plohoy.enterpriseservice.service.storeservice.impl;

import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.entity.FaktupnalInfo;
import com.plohoy.enterpriseservice.repository.FaktupnalInfoRepository;

/**
 * Faktupnal Store Service implementation.
 * Sets Faktupnal implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class FaktupnalStoreService
        extends AbstractStoreService<FaktupnalInfo, FaktupnalInfoRepository> {

    /**
     * Instantiates a new Faktupnal store service.
     * And sets Faktupnal Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository Faktupnal Repository
     */
    public FaktupnalStoreService(FaktupnalInfoRepository repository) {
        super(repository);
    }

    @Override
    protected FaktupnalInfo getNewEntity() {
        return new FaktupnalInfo();
    }
}