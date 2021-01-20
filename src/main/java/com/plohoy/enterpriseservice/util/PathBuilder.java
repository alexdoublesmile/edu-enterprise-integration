package com.plohoy.enterpriseservice.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * URL Build Utility class.<br>
 *     Gets URL path from path parts according to url.properties file & given parameters.
 */
@Component
public final class PathBuilder {

    @Value("${adapter.url}")
    private String adapterUrl;
    @Value("${path}")
    private String path;

    public String getRequestUrl(String specificPath) {
        return adapterUrl + path + specificPath;
    }

    public String getFindInfoByIdUrl(String specificPathTemplate, String clientId) {
        return String.format(
                adapterUrl + path +
                        specificPathTemplate, clientId);
    }
}
