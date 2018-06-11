package com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CertyfikatRequest extends RequestBase<CertyfikatRequest> {
    public static final String DEFAULT_SYSTEM_VERSION = "0.0.1";
    public static final String DEFAULT_SYSTEM_TYPE = "SDK";
    public static final String DEFAULT_DEVICE_NAME = "Unofficial SDK";

    @JsonProperty("PIN")
    private String pin;
    @JsonProperty("TokenKey")
    private String tokenKey;
    @JsonProperty("AppVersion")
    private String appVersion = RequestBase.APPLICATION_VERSION;
    @JsonProperty("DeviceId")
    private String deviceId = UUID.randomUUID().toString();
    @JsonProperty("DeviceName")
    private String deviceName = DEFAULT_DEVICE_NAME;
    @JsonProperty("DeviceNameUser ")
    private String deviceNameUser = "";
    @JsonProperty("DeviceDescription")
    private String deviceDescription = "";
    @JsonProperty("DeviceSystemType")
    private String deviceSystemType = DEFAULT_SYSTEM_TYPE;
    @JsonProperty("DeviceSystemVersion")
    private String deviceSystemVersion = DEFAULT_SYSTEM_VERSION;

    public CertyfikatRequest(String pin, String token) {
        this.pin = pin;
        this.tokenKey = token;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNameUser() {
        return deviceNameUser;
    }

    public void setDeviceNameUser(String deviceNameUser) {
        this.deviceNameUser = deviceNameUser;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    public String getDeviceSystemType() {
        return deviceSystemType;
    }

    public void setDeviceSystemType(String deviceSystemType) {
        this.deviceSystemType = deviceSystemType;
    }

    public String getDeviceSystemVersion() {
        return deviceSystemVersion;
    }

    public void setDeviceSystemVersion(String deviceSystemVersion) {
        this.deviceSystemVersion = deviceSystemVersion;
    }
}
