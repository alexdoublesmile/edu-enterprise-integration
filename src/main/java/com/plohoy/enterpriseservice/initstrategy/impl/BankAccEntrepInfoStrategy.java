package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.BankAccEntrepRequestDto;
import com.plohoy.enterpriseadapter.dto.BankAccEntrepResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

/**
 * BankAccEntrep Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class BankAccEntrepInfoStrategy implements BaseStrategy {
    @Value("${bank.acc.entrep.request.path}")
    private String requestPath;

    @Value("${find.bank.acc.entrep.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.SmevRequestType).BANK_ACC_ENTREP}")
    private SmevRequestType requestType;

    @Override
    public Object getRequestDto(String inn) {
        BankAccEntrepRequestDto requestDto = new BankAccEntrepRequestDto();

        requestDto.setИННФЛ(inn);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return BankAccEntrepResponseDto.class;
    }

}
