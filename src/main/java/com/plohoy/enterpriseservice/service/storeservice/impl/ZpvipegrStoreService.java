package com.plohoy.enterpriseservice.service.storeservice.impl;

import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.entity.ZpvipegrInfo;
import com.plohoy.enterpriseservice.repository.ZpvipegrInfoRepository;

/**
 * Zpvipegr Store Service implementation.
 * Sets Zpvipegr implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class ZpvipegrStoreService
        extends AbstractStoreService<ZpvipegrInfo, ZpvipegrInfoRepository> {

    /**
     * Instantiates a new Zpvipegr store service.
     * And sets Zpvipegr Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository Zpvipegr Repository
     */
    public ZpvipegrStoreService(ZpvipegrInfoRepository repository) {
        super(repository);
    }

    @Override
    protected ZpvipegrInfo getNewEntity() {
        return new ZpvipegrInfo();
    }
}
