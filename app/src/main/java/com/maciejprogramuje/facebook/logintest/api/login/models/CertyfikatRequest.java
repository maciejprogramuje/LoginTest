package com.maciejprogramuje.facebook.logintest.api.login.models;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class CertyfikatRequest {
    @SerializedName("PIN")
    public String pin;
    @SerializedName("TokenKey")
    public String tokenKey;
    @SerializedName("AppVersion")
    public String appVersion;
    @SerializedName("DeviceId")
    public String deviceId;
    @SerializedName("DeviceName")
    public String deviceName;
    @SerializedName("DeviceNameUser")
    public String deviceNameUser;
    @SerializedName("DeviceDescription")
    public String deviceDescription;
    @SerializedName("DeviceSystemType")
    public String deviceSystemType;
    @SerializedName("DeviceSystemVersion")
    public String deviceSystemVersion;
    @SerializedName("RemoteMobileTimeKey")
    public String remoteMobileTimeKey;
    @SerializedName("TimeKey")
    public String timeKey;
    @SerializedName("RequestId")
    public String requestId;
    @SerializedName("RemoteMobileAppVersion")
    public String remoteMobileAppVersion;
    @SerializedName("RemoteMobileAppName")
    public String remoteMobileAppName;

    public CertyfikatRequest(String pin, String tokenKey) {
        this.pin = pin;
        this.tokenKey = tokenKey;
        this.appVersion = "18.4.1.388";
        this.deviceId = UUID.randomUUID().toString();
        this.deviceName = "Dzienniczek V";
        this.deviceNameUser = "";
        this.deviceDescription = "";
        this.deviceSystemType = "Android";
        this.deviceSystemVersion = "7.1.2";
        this.timeKey = Long.toString(System.currentTimeMillis() / 1000L);
        this.remoteMobileTimeKey = Long.toString(System.currentTimeMillis() / 1000L - 1);
        this.requestId = UUID.randomUUID().toString();
        this.remoteMobileAppVersion = "18.4.1.388";
        this.remoteMobileAppName = "VULCAN-Android-ModulUcznia";
    }
}
