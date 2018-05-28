package com.maciejprogramuje.facebook.logintest.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class CertyfikatRequest extends RequestBase<Certyfikat.TokenCertificate> {
    @SerializedName("PIN")
    public String pin;
    @SerializedName("TokenKey")
    public String tokenKey;
    @SerializedName("DeviceNameUser")
    public String deviceNameUser;
    @SerializedName("DeviceSystemVersion")
    public String deviceSystemVersion;
    @SerializedName("DeviceDescription")
    public String deviceDescription;
    @SerializedName("DeviceId")
    public String deviceId;
    @SerializedName("DeviceName")
    public String deviceName;
    @SerializedName("DeviceSystemType")
    public String deviceSystemType;
    @SerializedName("AppVersion")
    public String appVersion;

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
    }
}
