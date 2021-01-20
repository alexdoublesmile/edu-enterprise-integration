package com.plohoy.enterpriseservice.repository;

import org.springframework.stereotype.Repository;
import com.plohoy.enterpriseservice.entity.SimpleInfo;

/**
 * Simple Repository implementation.
 *
 * @see BaseInfoRepository
 */
@Repository
public interface SimpleInfoRepository extends BaseInfoRepository<SimpleInfo> {
}
