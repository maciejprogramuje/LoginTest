package com.maciejprogramuje.facebook.logintest.uonet_api.log1_base_url;

public class BaseUrlReadyEvent {
    private final String baseUrl;

    public BaseUrlReadyEvent(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
