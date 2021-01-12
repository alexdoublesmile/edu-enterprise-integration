package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.BankAccEntrepInfo;
import com.plohoy.enterpriseservice.initstrategy.impl.BankAccEntrepInfoStrategy;

/**
 * BankAccEntrep Controller implementation.
 * Sets BankAccEntrep implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "BANKACCENTREP", description = "Отправка запроса на получение сведений о банковских счетах (депозитах) индивидуального предпринимателя по ИНН")
@RestController
@RequestMapping("/bankAccEntrep")
public class BankAccEntrepSyncController extends AbstractSyncController<BankAccEntrepInfo, BankAccEntrepInfoStrategy> {

    /**
     * Instantiates a new BankAccEntrep controller.
     * And sets BankAccEntrep Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     BankAccEntrep Strategy
     */
    public BankAccEntrepSyncController(BankAccEntrepInfoStrategy strategy) {
        super(strategy);
    }
}
