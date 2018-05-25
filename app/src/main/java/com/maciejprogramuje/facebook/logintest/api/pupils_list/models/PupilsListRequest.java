package com.maciejprogramuje.facebook.logintest.api.pupils_list.models;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class PupilsListRequest {
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

    public PupilsListRequest() {
        this.remoteMobileTimeKey = Long.toString(System.currentTimeMillis() / 1000L);;
        this.timeKey = Long.toString(System.currentTimeMillis() / 1000L - 1);
        this.requestId = UUID.randomUUID().toString();
        this.remoteMobileAppVersion = "18.4.1.388";
        this.remoteMobileAppName = "VULCAN-Android-ModulUcznia";
    }
}
