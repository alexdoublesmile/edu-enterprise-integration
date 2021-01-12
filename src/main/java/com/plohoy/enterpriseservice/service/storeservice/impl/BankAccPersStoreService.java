package com.plohoy.enterpriseservice.service.storeservice.impl;

import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.entity.BankAccPersInfo;
import com.plohoy.enterpriseservice.repository.BankAccPersInfoRepository;

/**
 * BankAccPers Store Service implementation.
 * Sets BankAccPers implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class BankAccPersStoreService
        extends AbstractStoreService<BankAccPersInfo, BankAccPersInfoRepository> {

    /**
     * Instantiates a new BankAccPers store service.
     * And sets BankAccPers Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository BankAccPers Repository
     */
    public BankAccPersStoreService(BankAccPersInfoRepository repository) {
        super(repository);
    }

    @Override
    protected BankAccPersInfo getNewEntity() {
        return new BankAccPersInfo();
    }
}