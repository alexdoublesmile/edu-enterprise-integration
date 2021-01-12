package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.FaktupnalInfo;
import com.plohoy.enterpriseservice.initstrategy.impl.FaktupnalInfoStrategy;

/**
 * Faktupnal Controller implementation.
 * Sets Faktupnal implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "FAKTUPNAL", description = "Отправка запроса на получение сведений о сумме фактически уплаченных юридическим лицом налогов по ИНН")
@RestController
@RequestMapping("/faktupnal")
public class FaktupnalSyncController extends AbstractSyncController<FaktupnalInfo, FaktupnalInfoStrategy> {

    /**
     * Instantiates a new Faktupnal controller.
     * And sets Faktupnal Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     Faktupnal Strategy
     */
    public FaktupnalSyncController(FaktupnalInfoStrategy strategy) {
        super(strategy);
    }
}