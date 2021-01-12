package com.plohoy.enterpriseservice.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.NDFL3ResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ndfl3Info Entity
 *
 * @see BaseJsonbEntity
 */
@Data
@Entity
@Table(name = "NDFL3")
public class Ndfl3Info extends BaseJsonbEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "NDFL3_INFO")
    private NDFL3ResponseDto info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (NDFL3ResponseDto) responseDto;
    }
}
