package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.BankAccPersRequestDto;
import com.plohoy.enterpriseadapter.dto.BankAccPersResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

/**
 * BankAccPers Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class BankAccPersInfoStrategy implements BaseStrategy {
    @Value("${bank.acc.pers.request.path}")
    private String requestPath;

    @Value("${find.bank.acc.pers.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.SmevRequestType).BANK_ACC_PERS}")
    private SmevRequestType requestType;

    @Override
    public Object getRequestDto(String inn) {
        BankAccPersRequestDto requestDto = new BankAccPersRequestDto();

        requestDto.setИННФЛ(inn);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return BankAccPersResponseDto.class;
    }
}
