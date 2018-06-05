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
    public String pin;
    @SerializedName("TokenKey")
    public String tokenKey;
    @SerializedName("AppVersion")
    public String appVersion = RequestBase.APPLICATION_VERSION;
    @SerializedName("DeviceId")
    public String deviceId = UUID.randomUUID().toString();
    @SerializedName("DeviceName")
    public String deviceName = DEFAULT_DEVICE_NAME;
    @SerializedName("DeviceNameUser ")
    public String deviceNameUser = "";
    @SerializedName("DeviceDescription")
    public String deviceDescription = "";
    @SerializedName("DeviceSystemType")
    public String deviceSystemType = DEFAULT_SYSTEM_TYPE;
    @SerializedName("DeviceSystemVersion")
    public String deviceSystemVersion = DEFAULT_SYSTEM_VERSION;
    @SerializedName("RemoteMobileTimeKey")
    public String remoteMobileTimeKey;
    @SerializedName("TimeKey")
    public String timeKey;
    @SerializedName("RequestId")
    public String requestId = UUID.randomUUID().toString();
    @SerializedName("RemoteMobileAppVersion")
    public String remoteMobileAppVersion = APPLICATION_VERSION;
    @SerializedName("RemoteMobileAppName")
    public String remoteMobileAppName = APPLICATION_NAME;


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
}
