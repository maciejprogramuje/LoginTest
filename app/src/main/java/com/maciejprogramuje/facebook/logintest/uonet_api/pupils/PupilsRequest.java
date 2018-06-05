package com.maciejprogramuje.facebook.logintest.uonet_api.pupils;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import static com.maciejprogramuje.facebook.logintest.uonet_api.models.CertyfikatRequest.APPLICATION_NAME;
import static com.maciejprogramuje.facebook.logintest.uonet_api.models.CertyfikatRequest.APPLICATION_VERSION;

public class PupilsRequest {
    @SerializedName("RemoteMobileTimeKey")
    public String remoteMobileTimeKey;
    @SerializedName("TimeKey")
    public String timeKey;
    @SerializedName("RequestId")
    public String requestId = UUID.randomUUID().toString();
    @SerializedName("RemoteMobileAppVersion")
    public String remoteMobileAppVersion = APPLICATION_VERSION;
    @SerializedName("RemoteMobileAppName")
    public String remoteMobileAppName = APPLICATION_NAME;

    public PupilsRequest() {
        long time = System.currentTimeMillis();
        if (this.remoteMobileTimeKey == null) {
            this.remoteMobileTimeKey = Long.toString(time / 1000L + 1);
        }
        if (this.timeKey == null) {
            this.timeKey = Long.toString(time / 1000L);
        }
    }
}
