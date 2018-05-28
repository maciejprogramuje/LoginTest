package com.maciejprogramuje.facebook.logintest.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

//public class UczniowieRequest extends RequestBase<List<Uczniowie.Uczen>> {
public class UczniowieRequest {
    @SerializedName("RemoteMobileAppVersion")
    public String remoteMobileAppVersion;
    @SerializedName("RemoteMobileAppName")
    public String remoteMobileAppName;
    @SerializedName("RemoteMobileTimeKey")
    public String remoteMobileTimeKey;
    @SerializedName("TimeKey")
    public String timeKey;
    @SerializedName("RequestId")
    public String requestId;

    public UczniowieRequest() {
        this.remoteMobileAppVersion = "18.4.1.388";
        this.remoteMobileAppName = "VULCAN-Android-ModulUcznia";
        this.remoteMobileTimeKey = Long.toString(System.currentTimeMillis() / 1000L - 1);
        this.timeKey = Long.toString(System.currentTimeMillis() / 1000L);
        this.requestId = UUID.randomUUID().toString();
    }

}
