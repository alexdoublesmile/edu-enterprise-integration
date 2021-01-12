package com.plohoy.enterpriseservice.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.DiskvlicResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DiskvlicInfo Entity
 *
 * @see BaseJsonbEntity
 */
@Data
@Entity
@Table(name = "DISKVLIC")
public class DiskvlicInfo extends BaseJsonbEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "DISKVLIC_INFO")
    private DiskvlicResponseDto info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (DiskvlicResponseDto) responseDto;
    }
}
