package com.plohoy.enterpriseservice.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.BankAccEntrepResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * BankAccEntrepInfo Entity
 *
 * @see BaseJsonbEntity
 */
@Data
@Entity
@Table(name = "BANK_ACC_ENTREP")
public class BankAccEntrepInfo extends BaseJsonbEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "BANK_ACC_ENTREP_INFO")
    private BankAccEntrepResponseDto info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (BankAccEntrepResponseDto) responseDto;
    }
}
