package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import static com.maciejprogramuje.facebook.logintest.uonet_api.models.CertyfikatRequest.APPLICATION_NAME;
import static com.maciejprogramuje.facebook.logintest.uonet_api.models.CertyfikatRequest.APPLICATION_VERSION;

public class UczniowieRequest3 {
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

    public UczniowieRequest3() {
        long time = System.currentTimeMillis();
        if (this.remoteMobileTimeKey == null) {
            this.remoteMobileTimeKey = Long.toString(time / 1000L + 1);
        }
        if (this.timeKey == null) {
            this.timeKey = Long.toString(time / 1000L);
        }
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
