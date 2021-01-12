package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.ZpvipegrInfo;
import com.plohoy.enterpriseservice.initstrategy.impl.ZpvipegrInfoStrategy;

/**
 * Zpvipegr Controller implementation.
 * Sets Zpvipegr implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "ZPVIPEGR", description = "Отправка запроса на предоставление выписки из ЕГРЮЛ, ЕГРИП в форме электронного документа по ИНН")
@RestController
@RequestMapping("/zpvipegr")
public class ZpvipegrSyncController extends AbstractSyncController<ZpvipegrInfo, ZpvipegrInfoStrategy> {

    /**
     * Instantiates a new Zpvipegr controller.
     * And sets Zpvipegr Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     Zpvipegr Strategy
     */
    public ZpvipegrSyncController(ZpvipegrInfoStrategy strategy) {
        super(strategy);
    }
}