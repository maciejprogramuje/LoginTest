package com.maciejprogramuje.facebook.logintest;

import android.app.Application;
import android.content.SharedPreferences;

import com.squareup.otto.Bus;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class App extends Application {
    public static final String BASE_URL_KEY = "baseUrl";
    public static final String CERTIFICATE_KEY = "certyficate";
    public static final String REQUEST_SIGNATURE_KEY = "requestSignature";


    private String baseUrl;
    private String certificateKey;
    private String requestSignature;

    private Bus bus;
    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        bus = new Bus();

        sharedPreferences = getDefaultSharedPreferences(this);
        baseUrl = sharedPreferences.getString(BASE_URL_KEY, "");
        certificateKey = sharedPreferences.getString(CERTIFICATE_KEY, "");
        requestSignature = sharedPreferences.getString(REQUEST_SIGNATURE_KEY, "");

        /*baseUrl = "https://lekcjaplus.vulcan.net.pl";
        certificateKey = "A6EEDF0788E1E3537E530508DC841852BB0D52E2";
        requestSignature = "BdZVeUBjjI4/uDuaVGRLJDuP5YEqsncQkgPBcWkz5CyYYmu0WIktJBNFSDtIN1f2nxRxdk4bc7ms3p85+MJJqwmXIWSSpBNzRg8BsTccuWnHSEpy8dRTLQ8d7Fmv3lrMUnJ/0Q2fN5O8K4eaU/XJYRR+RQ8phnqj/OBAPNMPLtQ=";
    */
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
        return certificateKey;
    }

    public void setCertificateKey(String certificateKey) {
        this.certificateKey = certificateKey;
    }

    public String getRequestSignature() {
        return requestSignature;
    }

    public void setRequestSignature(String requestSignature) {
        this.requestSignature = requestSignature;
    }
}
