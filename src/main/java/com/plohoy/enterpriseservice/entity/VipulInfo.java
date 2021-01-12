package com.plohoy.enterpriseservice.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.ResponseDto;
import com.plohoy.enterpriseadapter.dto.VipulResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VipulInfo Entity
 *
 * @see BaseJsonbEntity
 */
@Data
@Entity
@Table(name = "VIPUL")
public class VipulInfo extends BaseJsonbEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "VIPUL_INFO")
    private VipulResponseDto info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (VipulResponseDto) responseDto;
    }
}