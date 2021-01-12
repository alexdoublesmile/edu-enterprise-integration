package com.plohoy.enterpriseservice.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.BankAccOrgResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * BankAccOrgInfo Entity
 *
 * @see BaseJsonbEntity
 */
@Data
@Entity
@Table(name = "BANK_ACC_ORG")
public class BankAccOrgInfo extends BaseJsonbEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "BANK_ACC_ORG_INFO")
    private BankAccOrgResponseDto info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (BankAccOrgResponseDto) responseDto;
    }
}
