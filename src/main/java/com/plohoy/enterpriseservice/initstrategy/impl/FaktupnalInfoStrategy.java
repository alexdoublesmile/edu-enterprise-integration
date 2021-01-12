package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.FaktupnalRequestDto;
import com.plohoy.enterpriseadapter.dto.FaktupnalResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

/**
 * Faktupnal Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class FaktupnalInfoStrategy implements BaseStrategy {
    @Value("${fakt.up.nal.request.path}")
    private String requestPath;

    @Value("${find.fakt.up.nal.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.SmevRequestType).FAKTUPNAL}")
    private SmevRequestType requestType;

    @Override
    public Object getRequestDto(String inn) {
        FaktupnalRequestDto requestDto = new FaktupnalRequestDto();
        requestDto.setLegalPersonINN(inn);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return FaktupnalResponseDto.class;
    }
}