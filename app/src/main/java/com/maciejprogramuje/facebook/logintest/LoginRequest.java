package com.maciejprogramuje.facebook.logintest;

import java.util.UUID;

class LoginRequest {
    public String PIN;
    public String TokenKey;
    public String AppVersion;
    public String DeviceId;
    public String DeviceName;
    public String DeviceNameUser;
    public String DeviceDescription;
    public String DeviceSystemType;
    public String DeviceSystemVersion;
    public String RemoteMobileTimeKey;
    public String TimeKey;
    public String RequestId;
    public String RemoteMobileAppVersion;
    public String RemoteMobileAppName;

    public LoginRequest(String PIN, String tokenKey) {
        this.PIN = PIN;
        this.TokenKey = tokenKey;
        this.AppVersion = "18.4.1.388";
        this.DeviceId = UUID.randomUUID().toString();
        this.DeviceName = "Xiaomi Redmi 4X";
        this.DeviceNameUser = "";
        this.DeviceDescription = "";
        this.DeviceSystemType = "Android";
        this.DeviceSystemVersion = "7.1.2";
        this.TimeKey = Long.toString(System.currentTimeMillis() / 1000L);
        this.RemoteMobileTimeKey = Long.toString(System.currentTimeMillis() / 1000L - 1);
        this.RequestId = UUID.randomUUID().toString();
        this.RemoteMobileAppVersion = "18.4.1.388";
        this.RemoteMobileAppName = "VULCAN-Android-ModulUcznia";
    }
}
