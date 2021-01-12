package com.plohoy.enterpriseservice.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.entity.NdipsrInfo;
import com.plohoy.enterpriseservice.initstrategy.impl.NdipsrInfoStrategy;

/**
 * Ndipsr Controller implementation.
 * Sets Ndipsr implementations of Entity & Strategy to parent parameters
 *
 * @see AbstractSyncController
 */
@Tag(name = "NDIPSR", description = "Отправка запроса на получение сведений из налоговых деклараций, представленных индивидуальными предпринимателями, применяющими специальные налоговые режимы")
@RestController
@RequestMapping("/ndipsr")
public class NdipsrSyncController extends AbstractSyncController<NdipsrInfo, NdipsrInfoStrategy> {

    /**
     * Instantiates a new Ndipsr controller.
     * And sets Ndipsr Strategy implementations by parent constructor
     * @see AbstractSyncController
     *
     * @param strategy     Ndipsr Strategy
     */
    public NdipsrSyncController(NdipsrInfoStrategy strategy) {
        super(strategy);
    }
}