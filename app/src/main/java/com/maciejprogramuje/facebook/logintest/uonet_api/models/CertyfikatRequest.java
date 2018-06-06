package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class CertyfikatRequest {
    public static final String DEFAULT_SYSTEM_VERSION = "0.0.1";
    public static final String DEFAULT_SYSTEM_TYPE = "SDK";
    public static final String DEFAULT_DEVICE_NAME = "Unofficial SDK";
    public static final String APPLICATION_NAME = "VULCAN-Android-ModulUcznia";
    public static final String APPLICATION_VERSION = "18.4.1.388";

    @SerializedName("PIN")
    private String pin;
    @SerializedName("TokenKey")
    private String tokenKey;
    @SerializedName("AppVersion")
    private String appVersion = RequestBase.APPLICATION_VERSION;
    @SerializedName("DeviceId")
    private String deviceId = UUID.randomUUID().toString();
    @SerializedName("DeviceName")
    private String deviceName = DEFAULT_DEVICE_NAME;
    @SerializedName("DeviceNameUser ")
    private String deviceNameUser = "";
    @SerializedName("DeviceDescription")
    private String deviceDescription = "";
    @SerializedName("DeviceSystemType")
    private String deviceSystemType = DEFAULT_SYSTEM_TYPE;
    @SerializedName("DeviceSystemVersion")
    private String deviceSystemVersion = DEFAULT_SYSTEM_VERSION;
    @SerializedName("RemoteMobileTimeKey")
    private String remoteMobileTimeKey;
    @SerializedName("TimeKey")
    private String timeKey;
    @SerializedName("RequestId")
    private String requestId = UUID.randomUUID().toString();
    @SerializedName("RemoteMobileAppVersion")
    private String remoteMobileAppVersion = APPLICATION_VERSION;
    @SerializedName("RemoteMobileAppName")
    private String remoteMobileAppName = APPLICATION_NAME;


    public CertyfikatRequest(String pin, String token) {
        this.pin = pin;
        this.tokenKey = token;

        long time = System.currentTimeMillis();
        if (this.remoteMobileTimeKey == null) {
            this.remoteMobileTimeKey = Long.toString(time / 1000L + 1);
        }
        if (this.timeKey == null) {
            this.timeKey = Long.toString(time / 1000L);
        }
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

    public String getRemoteMobileTimeKey() {
        return remoteMobileTimeKey;
    }

    public void setRemoteMobileTimeKey(String remoteMobileTimeKey) {
        this.remoteMobileTimeKey = remoteMobileTimeKey;
    }

    public String getTimeKey() {
        return timeKey;
    }

    public void setTimeKey(String timeKey) {
        this.timeKey = timeKey;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRemoteMobileAppVersion() {
        return remoteMobileAppVersion;
    }

    public void setRemoteMobileAppVersion(String remoteMobileAppVersion) {
        this.remoteMobileAppVersion = remoteMobileAppVersion;
    }

    public String getRemoteMobileAppName() {
        return remoteMobileAppName;
    }

    public void setRemoteMobileAppName(String remoteMobileAppName) {
        this.remoteMobileAppName = remoteMobileAppName;
    }
}
