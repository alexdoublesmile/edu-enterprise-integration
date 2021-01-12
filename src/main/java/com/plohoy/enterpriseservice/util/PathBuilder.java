package com.plohoy.enterpriseservice.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * URL Build Utility class.<br>
 *     Gets URL path from path parts according to url.properties file & given parameters.
 */
@Component
public final class PathBuilder {

    @Value("${fns.adapter.url}")
    private String fnsAdapterUrl;
    @Value("${smev.fns.path}")
    private String smevFnsPath;

    public String getRequestUrl(String specificPath) {
        return fnsAdapterUrl + smevFnsPath + specificPath;
    }

    public String getFindInfoByIdUrl(String specificPathTemplate, String clientId) {
        return String.format(
                fnsAdapterUrl + smevFnsPath +
                        specificPathTemplate, clientId);
    }
}
