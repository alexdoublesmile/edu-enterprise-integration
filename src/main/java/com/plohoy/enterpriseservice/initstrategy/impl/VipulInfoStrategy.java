package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.ResponseDto;
import com.plohoy.enterpriseadapter.dto.VipulRequestDto;
import com.plohoy.enterpriseadapter.dto.VipulResponseDto;

/**
 * Vipul Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class VipulInfoStrategy implements BaseStrategy {
    @Value("${vip.ul.request.path}")
    private String requestPath;

    @Value("${find.vip.ul.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.SmevRequestType).VIPUL}")
    private SmevRequestType requestType;

    @Override
    public Object getRequestDto(String inn) {
        VipulRequestDto requestDto = new VipulRequestDto();
        VipulRequestDto.ЗапросЮЛ legalRequest = new VipulRequestDto.ЗапросЮЛ();

        legalRequest.setИННЮЛ(inn);
        requestDto.setЗапросЮЛ(legalRequest);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return VipulResponseDto.class;
    }
}
