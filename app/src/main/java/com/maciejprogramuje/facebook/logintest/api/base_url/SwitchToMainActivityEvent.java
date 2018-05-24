package com.maciejprogramuje.facebook.logintest.api.base_url;

public class SwitchToMainActivityEvent {
    private String baseUrl;

    public SwitchToMainActivityEvent(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
