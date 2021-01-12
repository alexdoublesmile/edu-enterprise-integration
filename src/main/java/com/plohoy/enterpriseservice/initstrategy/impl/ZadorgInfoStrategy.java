package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.ResponseDto;
import com.plohoy.enterpriseadapter.dto.ZadorgRequestDto;
import com.plohoy.enterpriseadapter.dto.ZadorgResponseDto;

/**
 * Zadorg Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class ZadorgInfoStrategy implements BaseStrategy {
    @Value("${zad.org.request.path}")
    private String requestPath;

    @Value("${find.zad.org.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.SmevRequestType).ZADORG}")
    private SmevRequestType requestType;

    @Override
    public Object getRequestDto(String inn) {
        ZadorgRequestDto requestDto = new ZadorgRequestDto();
        ZadorgRequestDto.ЗапросНП personRequest = new ZadorgRequestDto.ЗапросНП();

        personRequest.setИННЮЛ(inn);
        requestDto.setЗапросНП(personRequest);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return ZadorgResponseDto.class;
    }
}
