package com.plohoy.enterpriseservice.service.storeservice.impl;

import com.plohoy.enterpriseservice.request.RequestTask;
import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.entity.SimpleInfo;
import com.plohoy.enterpriseservice.repository.SimpleInfoRepository;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;

import java.util.Optional;

/**
 * Simple Store Service implementation.
 * Sets Simple implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class SimpleStoreService
        extends AbstractStoreService<SimpleInfo, SimpleInfoRepository> {

    /**
     * Instantiates a new Simple store service.
     * And sets Simple Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository Simple Repository
     */
    public SimpleStoreService(SimpleInfoRepository repository) {
        super(repository);
    }

    @Override
    protected SimpleInfo getNewEntity() {
        return new SimpleInfo();
    }

    @Override
    public Optional<SimpleInfo> findById(RequestTask task) {
        return Optional.empty();
    }
}
