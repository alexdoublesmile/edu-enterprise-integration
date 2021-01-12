package com.plohoy.enterpriseservice.entity;


import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.ResponseDto;
import com.plohoy.enterpriseadapter.dto.zpvipegr.ZpvipegrResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ZpvipegrInfo Entity
 *
 * @see BaseJsonbEntity
 */
@Data
@Entity
@Table(name = "ZPVIPEGR")
public class ZpvipegrInfo extends BaseJsonbEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "ZPVIPEGR_INFO")
    private ZpvipegrResponseDto info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (ZpvipegrResponseDto) responseDto;
    }
}