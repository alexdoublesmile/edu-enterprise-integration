package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.NDFL3RequestDto;
import com.plohoy.enterpriseadapter.dto.NDFL3ResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import java.io.Serializable;

/**
 * Ndfl3 Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class Ndfl3InfoStrategy implements BaseStrategy, Serializable {
    @Value("${ndfl3.request.path}")
    private String requestPath;

    @Value("${find.ndfl3.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.SmevRequestType).NDFL3}")
    private SmevRequestType requestType;

    @Override
    public Object getRequestDto(String inn) {
        NDFL3RequestDto requestDto = new NDFL3RequestDto();

        requestDto.setInn(inn);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return NDFL3ResponseDto.class;
    }

}
