package com.plohoy.enterpriseservice.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.ResponseDto;
import com.plohoy.enterpriseadapter.dto.ZadorgResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ZadorgInfo Entity
 *
 * @see BaseJsonbEntity
 */
@Data
@Entity
@Table(name = "ZADORG")
public class ZadorgInfo extends BaseJsonbEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "ZADORG_INFO")
    private ZadorgResponseDto info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (ZadorgResponseDto) responseDto;
    }
}
