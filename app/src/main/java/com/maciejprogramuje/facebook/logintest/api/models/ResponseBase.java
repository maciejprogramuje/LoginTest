package com.maciejprogramuje.facebook.logintest.api.models;

import com.google.gson.annotations.SerializedName;

public class ResponseBase<T> {
    @SerializedName("Status")
    public String status;
    @SerializedName("TimeKey")
    public Integer timeKey;
    @SerializedName("TimeValue")
    public String timeValue;
    @SerializedName("RequestId")
    public String requestId;
    @SerializedName("DayOfWeek")
    public Integer dayOfWeek;
    @SerializedName("AppVersion")
    public String appVersion;
    @SerializedName("Data")
    public T data;
}
