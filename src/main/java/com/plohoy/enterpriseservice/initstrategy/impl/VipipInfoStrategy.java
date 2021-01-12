package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.ResponseDto;
import com.plohoy.enterpriseadapter.dto.vipip.VipipRequestDto;
import com.plohoy.enterpriseadapter.dto.vipip.VipipResponseDto;

/**
 * Vipip Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class VipipInfoStrategy implements BaseStrategy {
    @Value("${vip.ip.request.path}")
    private String requestPath;

    @Value("${find.vip.ip.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.SmevRequestType).VIPIP}")
    private SmevRequestType requestType;

    @Override
    public Object getRequestDto(String inn) {
        VipipRequestDto requestDto = new VipipRequestDto();
        VipipRequestDto.ЗапросИП entrepRequest = new VipipRequestDto.ЗапросИП();

        entrepRequest.setИНН(inn);
        requestDto.setЗапросИП(entrepRequest);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return VipipResponseDto.class;
    }
}