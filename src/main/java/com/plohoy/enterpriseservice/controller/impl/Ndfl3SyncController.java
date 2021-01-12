package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.Ndfl3Info;
import com.plohoy.enterpriseservice.initstrategy.impl.Ndfl3InfoStrategy;

/**
 * Ndfl3 Controller implementation.
 * Sets Ndfl3 implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "NDFL3", description = "Отправка запроса на получение 3-НДФЛ по ИНН")
@RestController
@RequestMapping("/ndfl3")
public class Ndfl3SyncController extends AbstractSyncController<Ndfl3Info, Ndfl3InfoStrategy> {

    /**
     * Instantiates a new Ndfl3 controller.
     * And sets Ndfl3 Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     Ndfl3 Strategy
     */
    public Ndfl3SyncController(Ndfl3InfoStrategy strategy) {
        super(strategy);
    }
}
