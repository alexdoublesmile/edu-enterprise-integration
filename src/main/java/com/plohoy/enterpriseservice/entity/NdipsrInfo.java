package com.plohoy.enterpriseservice.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.NDIPSRResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * NdipsrInfo Entity
 *
 * @see BaseJsonbEntity
 */
@Data
@Entity
@Table(name = "NDIPSR")
public class NdipsrInfo extends BaseJsonbEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "NDIPSR_INFO")
    private NDIPSRResponseDto info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (NDIPSRResponseDto) responseDto;
    }
}