package com.plohoy.enterpriseservice.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import com.plohoy.enterpriseadapter.dto.ResponseDto;
import com.plohoy.enterpriseadapter.dto.fnszvipul.FnszvipulResponse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ZvipulInfo Entity
 *
 * @see BaseJsonbEntity
 */
@Data
@Entity
@Table(name = "ZVIPUL")
public class ZvipulInfo extends BaseJsonbEntity {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "ZVIPUL_INFO")
    private FnszvipulResponse info;

    @Override
    public void setInfo(ResponseDto responseDto) {
        info = (FnszvipulResponse) responseDto;
    }
}
