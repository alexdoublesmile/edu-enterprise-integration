package com.plohoy.enterpriseservice.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.BankAccPersResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * BankAccPersInfo Entity
 *
 * @see BaseJsonbEntity
 */
@Data
@Entity
@Table(name = "BANK_ACC_PERS")
public class BankAccPersInfo extends BaseJsonbEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "BANK_ACC_PERS_INFO")
    private BankAccPersResponseDto info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (BankAccPersResponseDto) responseDto;
    }
}
