package com.plohoy.enterpriseservice.service.storeservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.plohoy.enterpriseservice.entity.BaseJsonBinaryEntity;
import com.plohoy.enterpriseservice.repository.BaseInfoRepository;
import com.plohoy.enterpriseservice.request.RequestTask;
import com.plohoy.enterpriseservice.service.SyncService;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;

/**
 * Base Abstract Store Service.
 * All parameter types sets by current Store Service implementation
 *
 * @see BaseStoreService
 * @see BaseJsonBinaryEntity
 * @see com.plohoy.enterpriseservice.controller.AbstractSyncController
 * @param <T> proper Entity type parameter
 * @param <R> proper Repository type parameter
 */
@Slf4j
public abstract class AbstractStoreService
        <T extends BaseJsonBinaryEntity, R extends BaseInfoRepository<T>>
            implements BaseStoreService<T> {
    private final R repository;
    @Autowired private SyncService syncService;

    @Value("${cache.expired.hours}")
    private long cacheExpiredHours;

    /**
     * Gets from current Store Service implementation proper Repository and sets it to class parameter.
     *
     * @see BaseInfoRepository
     * @param repository proper Repository
     */
    @Autowired public AbstractStoreService(R repository) {
        this.repository = repository;
    }

    @Override public String saveInfoFromExtService(ResponseDto responseDto, String id) {
        T entityFromDB = repository.findByid(id);

        if (Objects.isNull(entityFromDB)) {
            log.debug(
                    "Запись {} для ID {} не найдена, создаем новую",
                    entityFromDB.getClass().getSimpleName(), id);

            entityFromDB = getNewEntity();

            entityFromDB.setId(id);
            entityFromDB.setInfo(responseDto);
            entityFromDB.setCreateDate(Instant.now());

        } else {
            log.debug(
                    "Найдена запись {} для ИНН {}, обновляем",
                    entityFromDB.getClass().getSimpleName(), id);

            entityFromDB.setInfo(responseDto);
            entityFromDB.setCreateDate(Instant.now());
        }

        return repository.save(entityFromDB)
                .getId().toString();
    }

    @Override public Optional<T> findByid(RequestTask task) {
        T entityFromDB = repository.findByid(task.getId());
        if (Objects.nonNull(entityFromDB)
                && isExpired(entityFromDB)) {

            entityFromDB.setCreateDate(Instant.now());
            repository.save(entityFromDB);

            syncService.synchronize(task);
        }
        return Optional.ofNullable(entityFromDB);
    }

    private boolean isExpired(T entityFromDB) {
        return entityFromDB.getCreateDate()
                .isBefore(
                        Instant.now().minus(cacheExpiredHours, ChronoUnit.HOURS));
    }

    protected abstract T getNewEntity();
//
//    @SneakyThrows
//    @Override
//    public T createRandomByid(RequestTask task) {
//        T entity = getNewEntity();
//        entity.setid(task.getid());
//        entity.setCreateDate(Instant.now());
//        ResponseDto info = task.getResponseDtoClass().newInstance();
//        entity.setInfo(info);
//
//        return repository.save(entity);
//    }
}
