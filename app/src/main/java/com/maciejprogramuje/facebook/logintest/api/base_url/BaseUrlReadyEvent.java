package com.maciejprogramuje.facebook.logintest.api.base_url;

public class BaseUrlReadyEvent {
    private String baseUrl;

    public BaseUrlReadyEvent(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
