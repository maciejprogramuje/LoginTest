package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public abstract class RequestAbst {
    public static final String APPLICATION_NAME = "VULCAN-Android-ModulUcznia";
    public static final String APPLICATION_VERSION = "18.4.1.388";

    @JsonProperty("RemoteMobileTimeKey")
    private String remoteMobileTimeKey;
    @JsonProperty("TimeKey")
    private String timeKey;
    @JsonProperty("RequestId")
    private String requestId = UUID.randomUUID().toString();
    @JsonProperty("RemoteMobileAppVersion")
    private String remoteMobileAppVersion = APPLICATION_VERSION;
    @JsonProperty("RemoteMobileAppName")
    private String remoteMobileAppName = APPLICATION_NAME;

    public RequestAbst() {
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
