package com.plohoy.enterpriseservice.request;

import lombok.Builder;
import lombok.Data;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import java.io.Serializable;

/**
 * Smev request task entity.
 */
@Data
@Builder
public class SmevRequestTask implements Serializable {
    private String clientId;
    private String inn;

    private String requestPath;
    private String findIdPathTemplate;

    private SmevRequestType requestType;

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
