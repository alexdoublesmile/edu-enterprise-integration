package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.ResponseDto;
import com.plohoy.enterpriseadapter.dto.zpvipegr.ZpvipegrRequestDto;
import com.plohoy.enterpriseadapter.dto.zpvipegr.ZpvipegrResponseDto;

/**
 * Zpvipegr Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class ZpvipegrInfoStrategy implements BaseStrategy {
    @Value("${zp.vip.egr.request.path}")
    private String requestPath;

    @Value("${find.zp.vip.egr.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.SmevRequestType).ZPVIPEGR}")
    private SmevRequestType requestType;

    @Override
    public Object getRequestDto(String inn) {
        ZpvipegrRequestDto requestDto = new ZpvipegrRequestDto();
        ZpvipegrRequestDto.СведЮЛ legalInfo = new ZpvipegrRequestDto.СведЮЛ();

        legalInfo.setИННЮЛВып(inn);
        requestDto.setСведЮЛ(legalInfo);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return ZpvipegrResponseDto.class;
    }
}
