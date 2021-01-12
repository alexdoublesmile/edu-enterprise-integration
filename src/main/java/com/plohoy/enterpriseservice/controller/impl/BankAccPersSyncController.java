package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.BankAccPersInfo;
import com.plohoy.enterpriseservice.initstrategy.impl.BankAccPersInfoStrategy;

/**
 * BankAccPers Controller implementation.
 * Sets BankAccPers implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "BANKACCPERS", description = "Отправка запроса на получение сведений о банковских счетах (вкладах) физического лица, не являющегося индивидуальным предпринимателем, по ИНН")
@RestController
@RequestMapping("/bankAccPers")
public class BankAccPersSyncController extends AbstractSyncController<BankAccPersInfo, BankAccPersInfoStrategy> {

    /**
     * Instantiates a new BankAccPers controller.
     * And sets BankAccPers Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     BankAccPers Strategy
     */
    public BankAccPersSyncController(BankAccPersInfoStrategy strategy) {
        super(strategy);
    }
}