package com.plohoy.enterpriseservice.request;

import lombok.Builder;
import lombok.Data;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import java.io.Serializable;

/**
 * Request task entity.
 */
@Data
@Builder
public class RequestTask implements Serializable {
    private String clientId;
    private String id;

    private String requestPath;
    private String findIdPathTemplate;

    private RequestType requestType;

    private Object requestDto;
    private Class<? extends ResponseDto> responseDtoClass;

    private Integer attempts;

    /**
     * Increases the number of attempts by 1.
     */
    public void increaseAttempts() {
        attempts++;
    }
}
