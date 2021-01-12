package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.DiskvlicRequestDto;
import com.plohoy.enterpriseadapter.dto.DiskvlicResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

/**
 * Diskvlic Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class DiskvlicInfoStrategy implements BaseStrategy {
    @Value("${diskv.lic.request.path}")
    private String requestPath;

    @Value("${find.diskv.lic.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.SmevRequestType).DISKVLIC}")
    private SmevRequestType requestType;

    @Override
    public Object getRequestDto(String inn) {
        DiskvlicRequestDto requestDto = new DiskvlicRequestDto();
        requestDto.setИдЗапрос(inn);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return DiskvlicResponseDto.class;
    }
}