package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.VipipInfo;
import com.plohoy.enterpriseservice.initstrategy.impl.VipipInfoStrategy;

/**
 * Vipip Controller implementation.
 * Sets Vipip implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "VIPIP", description = "Отправка запроса на получение выписки из ЕГРИП по запросам органов государственной власти по ИНН")
@RestController
@RequestMapping("/vipip")
public class VipipSyncController extends AbstractSyncController<VipipInfo, VipipInfoStrategy> {

    /**
     * Instantiates a new Vipip controller.
     * And sets Vipip Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     Vipip Strategy
     */
    public VipipSyncController(VipipInfoStrategy strategy) {
        super(strategy);
    }
}