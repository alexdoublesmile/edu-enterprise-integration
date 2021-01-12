package com.plohoy.enterpriseservice.service.storeservice.impl;

import org.springframework.stereotype.Service;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.entity.Ndfl3Info;
import com.plohoy.enterpriseservice.repository.Ndfl3InfoRepository;

/**
 * Ndfl3 Store Service implementation.
 * Sets Ndfl3 implementations of Entity & Repository to parent parameters
 *
 * @see AbstractStoreService
 */
@Service
public class Ndfl3StoreService
        extends AbstractStoreService<Ndfl3Info, Ndfl3InfoRepository> {

    /**
     * Instantiates a new Ndfl3 store service.
     * And sets Ndfl3 Repository implementation by parent constructor
     *
     * @see AbstractStoreService
     * @param repository Ndfl3 Repository
     */
    public Ndfl3StoreService(Ndfl3InfoRepository repository) {
        super(repository);
    }

    @Override
    protected Ndfl3Info getNewEntity() {
        return new Ndfl3Info();
    }
}
