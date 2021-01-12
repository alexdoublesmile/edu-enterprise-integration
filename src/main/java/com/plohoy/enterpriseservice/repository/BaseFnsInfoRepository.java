package com.plohoy.enterpriseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.plohoy.enterpriseservice.entity.BaseJsonbEntity;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;

/**
 * Base Repository Interface.<br>
 * Proper parameter type is setting by current repository implementation according to current store service implementation
 *
 * @param <T> Entity type parameter
 * @see AbstractStoreService
 */
@NoRepositoryBean
public interface BaseFnsInfoRepository<T extends BaseJsonbEntity> extends JpaRepository<T, String> {
    /**
     * Finds proper info from DB by INN according to current entity type.
     *
     * @param inn INN
     * @return proper Entity type
     * @see BaseJsonbEntity
     */
    T findByInn(String inn);
}
