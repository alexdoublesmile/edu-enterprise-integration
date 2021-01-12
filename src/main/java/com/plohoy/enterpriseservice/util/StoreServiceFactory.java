package com.plohoy.enterpriseservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.entity.BaseJsonbEntity;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseservice.service.storeservice.BaseStoreService;
import com.plohoy.enterpriseservice.service.storeservice.impl.*;

/**
 * Provides proper Store Service implementation according to SMEV request type argument
 */
@Component
public final class StoreServiceFactory {
    @Autowired ApplicationContext context;

    public BaseStoreService<? extends BaseJsonbEntity> getStoreService(SmevRequestType requestType) {
        switch (requestType) {
            case BANK_ACC_ENTREP:
                return context.getBean(BankAccEntrepStoreService.class);
            case BANK_ACC_ORG:
                return context.getBean(BankAccOrgStoreService.class);
            case BANK_ACC_PERS:
                return context.getBean(BankAccPersStoreService.class);
            case DISKVLIC:
                return context.getBean(DiskvlicStoreService.class);
            case FAKTUPNAL:
                return context.getBean(FaktupnalStoreService.class);
            case NDFL3:
                return context.getBean(Ndfl3StoreService.class);
            case NDIPSR:
                return context.getBean(NdipsrStoreService.class);
            case VIPIP:
                return context.getBean(VipipStoreService.class);
            case VIPUL:
                return context.getBean(VipulStoreService.class);
            case ZADORG:
                return context.getBean(ZadorgStoreService.class);
            case ZPVIPEGR:
                return context.getBean(ZpvipegrStoreService.class);
            case ZVIPUL:
                return context.getBean(ZvipulStoreService.class);
            default:
                return null;
        }
    }
}
