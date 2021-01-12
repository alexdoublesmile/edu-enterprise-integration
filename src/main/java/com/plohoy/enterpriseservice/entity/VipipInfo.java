package com.plohoy.enterpriseservice.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.ResponseDto;
import com.plohoy.enterpriseadapter.dto.vipip.VipipResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VipipInfo Entity
 *
 * @see BaseJsonbEntity
 */
@Data
@Entity
@Table(name = "VIPIP")
public class VipipInfo extends BaseJsonbEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "VIPIP_INFO")
    private VipipResponseDto info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (VipipResponseDto) responseDto;
    }
}
