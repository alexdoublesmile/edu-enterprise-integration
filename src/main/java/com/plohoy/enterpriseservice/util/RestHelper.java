package com.plohoy.enterpriseservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

/**
 * Rest Utility class.
 */
@Component
public final class RestHelper {
    @Autowired private RestTemplate restTemplate;

    /**
     * Gets response by sending URL to rest Template exchange method.
     *
     * @param url           request URL
     * @param responseClass proper response class
     * @return the response
     */
    public ResponseEntity<? extends ResponseDto> getResponse(String url, Class responseClass) {
        return restTemplate
                .exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        responseClass);
    }
}
