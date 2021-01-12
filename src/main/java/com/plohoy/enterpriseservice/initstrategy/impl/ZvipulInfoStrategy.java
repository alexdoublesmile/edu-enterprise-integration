package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.ResponseDto;
import com.plohoy.enterpriseadapter.dto.fnszvipul.FnszvipulRequest;
import com.plohoy.enterpriseadapter.dto.fnszvipul.FnszvipulResponse;

/**
 * Zvipul Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class ZvipulInfoStrategy implements BaseStrategy {
    @Value("${fns.zvip.ul.request.path}")
    private String requestPath;

    @Value("${find.fns.zvip.ul.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.SmevRequestType).ZVIPUL}")
    private SmevRequestType requestType;

    @Override
    public Object getRequestDto(String inn) {
        FnszvipulRequest requestDto = new FnszvipulRequest();
        FnszvipulRequest.ЗапросЮЛ legalRequest = new FnszvipulRequest.ЗапросЮЛ();

        legalRequest.setИННЮЛ(inn);
        requestDto.setЗапросЮЛ(legalRequest);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return FnszvipulResponse.class;
    }
}

