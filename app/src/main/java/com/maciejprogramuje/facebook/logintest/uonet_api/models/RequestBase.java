package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.ParameterizedType;
import java.net.URLConnection;
import java.util.UUID;

public abstract class RequestBase<T> {
    public static final String APPLICATION_NAME = "VULCAN-Android-ModulUcznia";
    public static final String APPLICATION_VERSION = "16.1.4.331";

    @SerializedName("RemoteMobileAppVersion")
    private String remoteMobileAppVersion = APPLICATION_VERSION;
    @SerializedName("RemoteMobileAppName")
    private String remoteMobileAppName = APPLICATION_NAME;
    @SerializedName("RemoteMobileTimeKey")
    private String remoteMobileTimeKey;
    @SerializedName("TimeKey")
    private String timeKey;
    @SerializedName("RequestId")
    private String requestId = UUID.randomUUID().toString();

    /**
     * Prepares the request before being sent i.e. populates empty fields if they are required.
     */
    public void prepare(URLConnection connection) {
        long time = System.currentTimeMillis();
        if (this.remoteMobileTimeKey == null) {
            this.remoteMobileTimeKey = Long.toString(time / 1000L + 1);
        }
        if (this.timeKey == null) {
            this.timeKey = Long.toString(time / 1000L);
        }
    }

    @JsonIgnore
    public Class<T> getResponseClass() {
        return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @JsonIgnore
    public abstract String getPath();

    public String getRemoteMobileAppVersion() {
        return this.remoteMobileAppVersion;
    }

    public void setRemoteMobileAppVersion(String remoteMobileAppVersion) {
        this.remoteMobileAppVersion = remoteMobileAppVersion;
    }

    public String getRemoteMobileAppName() {
        return this.remoteMobileAppName;
    }

    public void setRemoteMobileAppName(String remoteMobileAppName) {
        this.remoteMobileAppName = remoteMobileAppName;
    }

    public String getRemoteMobileTimeKey() {
        return this.remoteMobileTimeKey;
    }

    public void setRemoteMobileTimeKey(String remoteMobileTimeKey) {
        this.remoteMobileTimeKey = remoteMobileTimeKey;
    }

    public String getTimeKey() {
        return this.timeKey;
    }

    public void setTimeKey(String timeKey) {
        this.timeKey = timeKey;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
