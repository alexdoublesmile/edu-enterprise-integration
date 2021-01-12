package com.plohoy.enterpriseservice.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.FaktupnalResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * FaktupnalInfo Entity
 *
 * @see BaseJsonbEntity
 */
@Data
@Entity
@Table(name = "FAKTUPNAL")
public class FaktupnalInfo extends BaseJsonbEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "FAKTUPNAL_INFO")
    private FaktupnalResponseDto info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (FaktupnalResponseDto) responseDto;
    }
}