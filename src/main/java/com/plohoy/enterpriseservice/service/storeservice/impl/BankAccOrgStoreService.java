package com.plohoy.enterpriseservice.service.storeservice.impl;

import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.entity.BankAccOrgInfo;
import com.plohoy.enterpriseservice.repository.BankAccOrgInfoRepository;

/**
 * BankAccOrg Store Service implementation.
 * Sets BankAccOrg implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class BankAccOrgStoreService
        extends AbstractStoreService<BankAccOrgInfo, BankAccOrgInfoRepository> {

    /**
     * Instantiates a new BankAccOrg store service.
     * And sets BankAccOrg Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository BankAccOrg Repository
     */
    public BankAccOrgStoreService(BankAccOrgInfoRepository repository) {
        super(repository);
    }

    @Override
    protected BankAccOrgInfo getNewEntity() {
        return new BankAccOrgInfo();
    }
}