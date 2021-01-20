package com.plohoy.enterpriseservice.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * Base Abstract Entity.
 */
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Data
@MappedSuperclass
public abstract class BaseJsonBinaryEntity implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "create_date")
    private Instant createDate;

    /**
     * Sets ResponseDTO object to proper info field of the current entity.
     *
     * @param responseDto response dto
     */
    public abstract void setInfo(ResponseDto responseDto);

    /**
     * Gets ResponseDTO object from proper info field of the current entity.
     *
     * @return responseDto
     */
    public abstract ResponseDto getInfo();
}
