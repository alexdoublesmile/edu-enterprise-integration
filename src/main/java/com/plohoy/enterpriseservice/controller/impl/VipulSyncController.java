package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.VipulInfo;
import com.plohoy.enterpriseservice.initstrategy.impl.VipulInfoStrategy;

/**
 * Vipul Controller implementation.
 * Sets Vipul implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "VIPUL", description = "Отправка запроса на получение выписки из ЕГРЮЛ по запросам органов государственной власти по ИНН")
@RestController
@RequestMapping("/vipul")
public class VipulSyncController extends AbstractSyncController<VipulInfo, VipulInfoStrategy> {

    /**
     * Instantiates a new Vipul controller.
     * And sets Vipul Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     Vipul Strategy
     */
    public VipulSyncController(VipulInfoStrategy strategy) {
        super(strategy);
    }
}