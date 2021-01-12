package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.DiskvlicInfo;
import com.plohoy.enterpriseservice.initstrategy.impl.DiskvlicInfoStrategy;

/**
 * Diskvlic Controller implementation.
 * Sets Diskvlic implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "DISKVLIC", description = "Отправка запроса на получение информация из реестра дисквалифицированных лиц по ИНН")
@RestController
@RequestMapping("/diskvlic")
public class DiskvlicSyncController extends AbstractSyncController<DiskvlicInfo, DiskvlicInfoStrategy> {

    /**
     * Instantiates a new Diskvlic controller.
     * And sets Diskvlic Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     Diskvlic Strategy
     */
    public DiskvlicSyncController(DiskvlicInfoStrategy strategy) {
        super(strategy);
    }
}
