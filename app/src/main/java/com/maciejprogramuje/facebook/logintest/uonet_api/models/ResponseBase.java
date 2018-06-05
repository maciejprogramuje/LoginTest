package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseBase<T> {
    @JsonProperty("Status")
    public String status;
    @JsonProperty("TimeKey")
    public Integer timeKey;
    @JsonProperty("TimeValue")
    public String timeValue;
    @JsonProperty("RequestId")
    public String requestId;
    @JsonProperty("DayOfWeek")
    public Integer dayOfWeek;
    @JsonProperty("AppVersion")
    public String appVersion;
    @JsonProperty("Data")
    public T data;
}
