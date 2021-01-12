package com.plohoy.enterpriseservice.initstrategy.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseadapter.dto.BankAccOrgRequestDto;
import com.plohoy.enterpriseadapter.dto.BankAccOrgResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

/**
 * BankAccOrg Strategy implementation.
 *
 * @see BaseStrategy
 */
@Component
@Data
public class BankAccOrgInfoStrategy implements BaseStrategy {
    @Value("${bank.acc.org.request.path}")
    private String requestPath;

    @Value("${find.bank.acc.org.path.template}")
    private String findIdPathTemplate;

    @Value("#{T(com.plohoy.enterpriseservice.request.SmevRequestType).BANK_ACC_ORG}")
    private SmevRequestType requestType;

    @Override
    public Object getRequestDto(String inn) {
        BankAccOrgRequestDto requestDto = new BankAccOrgRequestDto();
        BankAccOrgRequestDto.СвРосОрг orgInfo = new BankAccOrgRequestDto.СвРосОрг();

        orgInfo.setИННЮЛ(inn);
        requestDto.setСвРосОрг(orgInfo);
        return requestDto;
    }

    @Override
    public Class<? extends ResponseDto> getResponseDtoClass() {
        return BankAccOrgResponseDto.class;
    }

}
