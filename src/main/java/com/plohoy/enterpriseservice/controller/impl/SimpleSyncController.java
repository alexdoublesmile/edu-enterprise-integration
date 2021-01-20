package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.SimpleInfo;
import com.plohoy.enterpriseservice.initstrategy.impl.SimpleInfoStrategy;

/**
 * Simple Controller implementation.
 * Sets Simple implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "Simple Example", description = "Отправка запроса на получение сведений")
@RestController
@RequestMapping("/simple")
public class SimpleSyncController extends AbstractSyncController<SimpleInfo, SimpleInfoStrategy> {

    /**
     * Instantiates a new Simple controller.
     * And sets Simple Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     Simple Strategy
     */
    public SimpleSyncController(SimpleInfoStrategy strategy) {
        super(strategy);
    }
}
