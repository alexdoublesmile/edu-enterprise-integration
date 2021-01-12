package com.plohoy.enterpriseservice.util;

import lombok.experimental.UtilityClass;
import com.plohoy.enterpriseservice.controller.impl.*;
import com.plohoy.enterpriseservice.entity.*;
import com.plohoy.enterpriseservice.initstrategy.impl.*;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseservice.service.storeservice.impl.*;
import com.plohoy.enterpriseadapter.dto.*;
import com.plohoy.enterpriseadapter.dto.fnszvipul.FnszvipulRequest;
import com.plohoy.enterpriseadapter.dto.fnszvipul.FnszvipulResponse;
import com.plohoy.enterpriseadapter.dto.vipip.VipipRequestDto;
import com.plohoy.enterpriseadapter.dto.vipip.VipipResponseDto;
import com.plohoy.enterpriseadapter.dto.zpvipegr.ZpvipegrRequestDto;
import com.plohoy.enterpriseadapter.dto.zpvipegr.ZpvipegrResponseDto;

@UtilityClass
public class TestCaseBuilder {
    private final Object[][] SYNC_TEST_CASES = new Object[][] {
            {
                    BankAccEntrepInfo.class,
                    BankAccEntrepInfoStrategy.class,
                    BankAccEntrepSyncController.class,
                    BankAccEntrepStoreService.class,
                    BankAccEntrepRequestDto.class,
                    BankAccEntrepResponseDto.class,
                    "bankAccEntrep",
                    "/bankAccEntrepRequest",
                    "/findBankAccEntrepMessageByClientId/%s",
                    SmevRequestType.BANK_ACC_ENTREP
            },
            {
                    BankAccOrgInfo.class,
                    BankAccOrgInfoStrategy.class,
                    BankAccOrgSyncController.class,
                    BankAccOrgStoreService.class,
                    BankAccOrgRequestDto.class,
                    BankAccOrgResponseDto.class,
                    "bankAccOrg",
                    "/bankAccOrgRequest",
                    "/findBankAccOrgMessageByClientId/%s",
                    SmevRequestType.BANK_ACC_ORG
            },
            {
                    BankAccPersInfo.class,
                    BankAccPersInfoStrategy.class,
                    BankAccPersSyncController.class,
                    BankAccPersStoreService.class,
                    BankAccPersRequestDto.class,
                    BankAccPersResponseDto.class,
                    "bankAccPers",
                    "/bankAccPersRequest",
                    "/findBankAccPersMessageByClientId/%s",
                    SmevRequestType.BANK_ACC_PERS
            },
            {
                    DiskvlicInfo.class,
                    DiskvlicInfoStrategy.class,
                    DiskvlicSyncController.class,
                    DiskvlicStoreService.class,
                    DiskvlicRequestDto.class,
                    DiskvlicResponseDto.class,
                    "diskvlic",
                    "/diskvlicRequest",
                    "/findDiskvlicMessageByClientId/%s",
                    SmevRequestType.DISKVLIC
            },
            {
                    FaktupnalInfo.class,
                    FaktupnalInfoStrategy.class,
                    FaktupnalSyncController.class,
                    FaktupnalStoreService.class,
                    FaktupnalRequestDto.class,
                    FaktupnalResponseDto.class,
                    "faktupnal",
                    "/faktupnalRequest",
                    "/findFaktupnalMessageByClientId/%s",
                    SmevRequestType.FAKTUPNAL
            },
            {
                    Ndfl3Info.class,
                    Ndfl3InfoStrategy.class,
                    Ndfl3SyncController.class,
                    Ndfl3StoreService.class,
                    NDFL3RequestDto.class,
                    NDFL3ResponseDto.class,
                    "ndfl3",
                    "/3NDFLRequest",
                    "/find3NDFLMessageByClientId/%s",
                    SmevRequestType.NDFL3
            },
            {
                    NdipsrInfo.class,
                    NdipsrInfoStrategy.class,
                    NdipsrSyncController.class,
                    NdipsrStoreService.class,
                    NDIPSRRequestDto.class,
                    NDIPSRResponseDto.class,
                    "ndipsr",
                    "/ndipsrRequest",
                    "/findNdipsrMessageByClientId/%s",
                    SmevRequestType.NDIPSR
            },
            {
                    VipipInfo.class,
                    VipipInfoStrategy.class,
                    VipipSyncController.class,
                    VipipStoreService.class,
                    VipipRequestDto.class,
                    VipipResponseDto.class,
                    "vipip",
                    "/vipipRequest",
                    "/findVipipMessageByClientId/%s",
                    SmevRequestType.VIPIP
            },
            {
                    VipulInfo.class,
                    VipulInfoStrategy.class,
                    VipulSyncController.class,
                    VipulStoreService.class,
                    VipulRequestDto.class,
                    VipulResponseDto.class,
                    "vipul",
                    "/vipulRequest",
                    "/findVipulMessageByClientId/%s",
                    SmevRequestType.VIPUL
            },
            {
                    ZadorgInfo.class,
                    ZadorgInfoStrategy.class,
                    ZadorgSyncController.class,
                    ZadorgStoreService.class,
                    ZadorgRequestDto.class,
                    ZadorgResponseDto.class,
                    "zadorg",
                    "/zadorgRequest",
                    "/findZadorgMessageByClientId/%s",
                    SmevRequestType.ZADORG
            },
            {
                    ZpvipegrInfo.class,
                    ZpvipegrInfoStrategy.class,
                    ZpvipegrSyncController.class,
                    ZpvipegrStoreService.class,
                    ZpvipegrRequestDto.class,
                    ZpvipegrResponseDto.class,
                    "zpvipegr",
                    "/zpvipegrRequest",
                    "/findZpvipegrMessageByClientId/%s",
                    SmevRequestType.ZPVIPEGR
            },
            {
                    ZvipulInfo.class,
                    ZvipulInfoStrategy.class,
                    ZvipulSyncController.class,
                    ZvipulStoreService.class,
                    FnszvipulRequest.class,
                    FnszvipulResponse.class,
                    "zvipul",
                    "/fnszvipulRequest",
                    "/findFnszvipulMessageByClientId/%s",
                    SmevRequestType.ZVIPUL
            }
    };

    private final Object[][] SQL_TEST_CASES = new Object[][] {
            {
                    "bankAccEntrep",
                    "123456",
                    50
            },
            {
                    "bankAccOrg",
                    "1234567",
                    52
            },
            {
                    "bankAccPers",
                    "12345678",
                    50
            },
            {
                    "diskvlic",
                    "123456789",
                    69
            },
            {
                    "faktupnal",
                    "1234567890",
                    66
            },
            {
                    "ndfl3",
                    "12345678901",
                    64
            },
            {
                    "ndipsr",
                    "123456789012",
                    36
            },
            {
                    "vipip",
                    "1234567890123",
                    79
            },
            {
                    "vipul",
                    "12345678901234",
                    79
            },
            {
                    "zadorg",
                    "123456789012345",
                    73
            },
            {
                    "zpvipegr",
                    "1234567890123456",
                    131
            },
            {
                    "zvipul",
                    "12345678901234567",
                    55
            }
    };

    public Object[][] getSyncTestCases() {
        return SYNC_TEST_CASES;
    }
    public Object[][] getSqlTestCases() {
        return SQL_TEST_CASES;
    }
}
