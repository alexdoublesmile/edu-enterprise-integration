package com.plohoy.enterpriseservice.request;

/**
 * request types enumeration.
 */
public enum RequestType {
    SIMPLE("simple");

    private String name;

    RequestType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static RequestType findByName(String name) {
        for (RequestType value : RequestType.values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }
}
