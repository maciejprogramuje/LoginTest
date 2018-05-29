package com.maciejprogramuje.facebook.logintest.uonet_api.base_url;

public class LoginSuccessEvent {
    private final String baseUrl;

    public LoginSuccessEvent(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
