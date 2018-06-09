package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstResponse<T> {
    @JsonProperty("Status")
    private String status;
    @JsonProperty("TimeKey")
    private Integer timeKey;
    @JsonProperty("TimeValue")
    private String timeValue;
    @JsonProperty("RequestId")
    private String requestId;
    @JsonProperty("DayOfWeek")
    private Integer dayOfWeek;
    @JsonProperty("AppVersion")
    private String appVersion;
    @JsonProperty("Data")
    private T data;
    //private List<T> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTimeKey() {
        return timeKey;
    }

    public void setTimeKey(Integer timeKey) {
        this.timeKey = timeKey;
    }

    public String getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(String timeValue) {
        this.timeValue = timeValue;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
