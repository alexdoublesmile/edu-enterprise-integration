package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.NDFL3ResponseDto;
import com.plohoy.enterpriseadapter.dto.NDIPSRRequestDto;
import com.plohoy.enterpriseadapter.dto.NDIPSRResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

/**
 * Ndipsr Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class NdipsrInfoStrategy implements BaseStrategy {
    @Value("${ndipsr.request.path}")
    private String requestPath;

    @Value("${find.ndipsr.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.SmevRequestType).NDIPSR}")
    private SmevRequestType requestType;

    @Override
    public Object getRequestDto(String inn) {
        NDIPSRRequestDto requestDto = new NDIPSRRequestDto();
        NDIPSRRequestDto.СведИП entrepInfo = new NDIPSRRequestDto.СведИП();

        entrepInfo.setИННФЛ(inn);
        requestDto.setСведИП(entrepInfo);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return NDIPSRResponseDto.class;
    }
}