package com.plohoy.enterpriseservice.service.storeservice.impl;

import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.entity.BankAccEntrepInfo;
import com.plohoy.enterpriseservice.repository.BankAccEntrepInfoRepository;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;

/**
 * BankAccEntrep Store Service implementation.
 * Sets BankAccEntrep implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class BankAccEntrepStoreService
        extends AbstractStoreService<BankAccEntrepInfo, BankAccEntrepInfoRepository> {

    /**
     * Instantiates a new BankAccEntrep store service.
     * And sets BankAccEntrep Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository BankAccEntrep Repository
     */
    public BankAccEntrepStoreService(BankAccEntrepInfoRepository repository) {
        super(repository);
    }

    @Override
    protected BankAccEntrepInfo getNewEntity() {
        return new BankAccEntrepInfo();
    }
}
