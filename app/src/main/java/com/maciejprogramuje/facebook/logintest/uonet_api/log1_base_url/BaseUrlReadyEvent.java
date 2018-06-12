package com.maciejprogramuje.facebook.logintest.uonet_api.log1_base_url;

public class BaseUrlReadyEvent {
    private final String baseUrl;
    private final String pin;
    private final String token;

    public BaseUrlReadyEvent(String baseUrl, String pin, String token) {
        this.baseUrl = baseUrl;
        this.pin = pin;
        this.token = token;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getPin() {
        return pin;
    }

    public String getToken() {
        return token;
    }
}
