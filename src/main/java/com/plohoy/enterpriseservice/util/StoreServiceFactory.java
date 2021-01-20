package com.plohoy.enterpriseservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.entity.BaseJsonBinaryEntity;
import com.plohoy.enterpriseservice.request.RequestType;
import com.plohoy.enterpriseservice.service.storeservice.BaseStoreService;
import com.plohoy.enterpriseservice.service.storeservice.impl.*;

/**
 * Provides proper Store Service implementation according to Request type argument
 */
@Component
public final class StoreServiceFactory {
    @Autowired ApplicationContext context;

    public BaseStoreService<? extends BaseJsonBinaryEntity> getStoreService(RequestType requestType) {
        switch (requestType) {
            case SIMPLE:
                return context.getBean(SimpleStoreService.class);
            default:
                return null;
        }
    }
}
