package com.plohoy.enterpriseservice.initstrategy;

import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import java.io.Serializable;

/**
 * Base Strategy Interface.<br>
 * Used for setting proper DTO objects & url initialization.<br>
 * Proper implementation is setting by current Controller implementation to Strategy helper Utility class
 *
 * @see com.plohoy.enterpriseservice.controller.AbstractSyncController
 */
public interface BaseStrategy extends Serializable {
    /**
     * Gets proper RequestDto(sets INN to it from current Smev request type)
     * @param inn INN
     */
    Object getRequestDto(String inn);

    /**
     * Gets proper ResponseDtoClass
     */
    Class<? extends ResponseDto> getResponseDtoClass();


    /**
     * Gets proper type if Request
     */
    SmevRequestType getRequestType();

    /**
     * Gets from url.property file proper request specific path(fns/smev/[requestpath]).
     */
    String getRequestPath();

    /**
     * Gets from url.property file proper response specific path(fns/smev/[findInfoByClientId]/[id] - path template for searching client by id).
     */
    String getFindIdPathTemplate();

}
