package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.ZvipulInfo;
import com.plohoy.enterpriseservice.initstrategy.impl.ZvipulInfoStrategy;

/**
 * Zvipul Controller implementation.
 * Sets Zvipul implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "ZVIPUL", description = "Отправка запроса на получение выписки из ЕГРЮЛ по запросам органов государственной власти, имеющих право на получение закрытых сведений по ИНН")
@RestController
@RequestMapping("/zvipul")
public class ZvipulSyncController extends AbstractSyncController<ZvipulInfo, ZvipulInfoStrategy> {

    /**
     * Instantiates a new Zvipul controller.
     * And sets Zvipul Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     Zvipul Strategy
     */
    public ZvipulSyncController(ZvipulInfoStrategy strategy) {
        super(strategy);
    }
}