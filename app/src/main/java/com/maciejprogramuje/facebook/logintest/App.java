package com.maciejprogramuje.facebook.logintest;

import android.app.Application;
import android.content.SharedPreferences;

import com.squareup.otto.Bus;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class App extends Application {
    public static final String BASE_URL_KEY = "baseUrl";
    public static final String CERTIFICATE_KEY = "certyficate";

    private Bus bus;
    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        bus = new Bus();
        sharedPreferences = getDefaultSharedPreferences(this);
    }


    public Bus getBus() {
        return bus;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
