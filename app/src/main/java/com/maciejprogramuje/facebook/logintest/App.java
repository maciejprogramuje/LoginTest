package com.maciejprogramuje.facebook.logintest;

import android.app.Application;
import android.content.SharedPreferences;

import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiUonet;
import com.squareup.otto.Bus;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class App extends Application {
    public static final String BASE_URL_KEY = "baseUrl";
    public static final String PFX_KEY = "pfx";
    public static final String CERTYFICATE_KEY_KEY = "certyficateKey";

    private String certyficateKey;
    private String pfx;
    private String baseUrl;

    private Bus bus;
    private SharedPreferences sharedPreferences;
    private ApiUonet apiUonet;

    @Override
    public void onCreate() {
        super.onCreate();

        bus = new Bus();

        sharedPreferences = getDefaultSharedPreferences(this);
        baseUrl = sharedPreferences.getString(BASE_URL_KEY, "");
        pfx = sharedPreferences.getString(PFX_KEY, "");
        certyficateKey = sharedPreferences.getString(CERTYFICATE_KEY_KEY, "");
    }


    public Bus getBus() {
        return bus;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getCertificateKey() {
        return certyficateKey;
    }

    public void setCertyficateKey(String certyficateKey) {
        this.certyficateKey = certyficateKey;
    }

    public String getPfx() {
        return pfx;
    }

    public void setPfx(String pfx) {
        this.pfx = pfx;
    }

    public ApiUonet getApiUonet() {
        return apiUonet;
    }

    public void setApiUonet(ApiUonet apiUonet) {
        this.apiUonet = apiUonet;
    }
}
