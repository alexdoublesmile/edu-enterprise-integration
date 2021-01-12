package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.BankAccOrgInfo;
import com.plohoy.enterpriseservice.initstrategy.impl.BankAccOrgInfoStrategy;

/**
 * BankAccOrg Controller implementation.
 * Sets BankAccOrg implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "BANKACCORG", description = "Отправка запроса на получение сведений о банковских счетах (депозитах) организации по ИНН")
@RestController
@RequestMapping("/bankAccOrg")
public class BankAccOrgSyncController extends AbstractSyncController<BankAccOrgInfo, BankAccOrgInfoStrategy> {

    /**
     * Instantiates a new BankAccOrg controller.
     * And sets BankAccOrg Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     BankAccOrg Strategy
     */
    public BankAccOrgSyncController(BankAccOrgInfoStrategy strategy) {
        super(strategy);
    }
}
