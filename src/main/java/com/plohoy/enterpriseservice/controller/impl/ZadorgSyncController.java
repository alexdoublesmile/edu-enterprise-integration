package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.ZadorgInfo;
import com.plohoy.enterpriseservice.initstrategy.impl.ZadorgInfoStrategy;

/**
 * Zadorg Controller implementation.
 * Sets Zadorg implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "ZADORG", description = "Отправка запроса на получение сведений о наличии (отсутствии) задолженности по уплате налогов, сборов, пеней, штрафов по ИНН")
@RestController
@RequestMapping("/zadorg")
public class ZadorgSyncController extends AbstractSyncController<ZadorgInfo, ZadorgInfoStrategy> {

    /**
     * Instantiates a new Zadorg controller.
     * And sets Zadorg Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     Zadorg Strategy
     */
    public ZadorgSyncController(ZadorgInfoStrategy strategy) {
        super(strategy);
    }
}