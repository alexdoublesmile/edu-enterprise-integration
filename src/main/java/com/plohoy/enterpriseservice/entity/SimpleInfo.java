package com.plohoy.enterpriseservice.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.SimpleResponseDto;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SimpleInfo Entity
 *
 * @see BaseJsonBinaryEntity
 */
@Data
@Entity
@Table
public class SimpleInfo extends BaseJsonBinaryEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "SIMPLE_INFO")
    private SimpleResponseDto info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (SimpleResponseDto) responseDto;
    }
}
