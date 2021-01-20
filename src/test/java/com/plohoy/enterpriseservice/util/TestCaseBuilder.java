package com.plohoy.enterpriseservice.util;

import lombok.experimental.UtilityClass;
import com.plohoy.enterpriseservice.controller.impl.*;
import com.plohoy.enterpriseservice.entity.*;
import com.plohoy.enterpriseservice.initstrategy.impl.*;
import com.plohoy.enterpriseservice.request.RequestType;
import com.plohoy.enterpriseservice.service.storeservice.impl.*;
import com.plohoy.enterpriseadapter.dto.*;

@UtilityClass
public class TestCaseBuilder {
    private final Object[][] SYNC_TEST_CASES = new Object[][] {
            {
                    SimpleInfo.class,
                    SimpleInfoStrategy.class,
                    SimpleSyncController.class,
                    SimpleStoreService.class,
                    SimpleRequestDto.class,
                    SimpleResponseDto.class,
                    "simple",
                    "/simpleRequest",
                    "/findSimpleMessageByClientId/%s",
                    RequestType.SIMPLE
            }
    };

    private final Object[][] SQL_TEST_CASES = new Object[][] {
            {
                    "simple",
                    "123456",
                    50
            }
    };

    public Object[][] getSyncTestCases() {
        return SYNC_TEST_CASES;
    }
    public Object[][] getSqlTestCases() {
        return SQL_TEST_CASES;
    }
}
