package com.plohoy.enterpriseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.plohoy.enterpriseservice.entity.BaseJsonBinaryEntity;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;

/**
 * Base Repository Interface.<br>
 * Proper parameter type is setting by current repository implementation according to current store service implementation
 *
 * @param <T> Entity type parameter
 * @see AbstractStoreService
 */
@NoRepositoryBean
public interface BaseInfoRepository<T extends BaseJsonBinaryEntity> extends JpaRepository<T, String> {
    /**
     * Finds proper info from DB by id according to current entity type.
     *
     * @param id id
     * @return proper Entity type
     * @see BaseJsonBinaryEntity
     */
    T findByid(String id);
}
