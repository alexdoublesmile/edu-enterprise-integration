package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.RequestType;
import com.plohoy.enterpriseadapter.dto.SimpleRequestDto;
import com.plohoy.enterpriseadapter.dto.SimpleResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

/**
 * Simple Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class SimpleInfoStrategy implements BaseStrategy {
    @Value("${simple.request.path}")
    private String requestPath;

    @Value("${find.simple.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.RequestType).SIMPLE}")
    private RequestType requestType;

    @Override
    public Object getRequestDto(String id) {
        SimpleRequestDto requestDto = new SimpleRequestDto();

        requestDto.setSpecificId(id);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return SimpleResponseDto.class;
    }

}
