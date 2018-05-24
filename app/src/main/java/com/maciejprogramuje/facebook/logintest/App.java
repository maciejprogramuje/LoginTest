package com.maciejprogramuje.facebook.logintest;

import android.app.Application;

import com.squareup.otto.Bus;

public class App extends Application {
    private Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();

        bus = new Bus();
    }

    public Bus getBus() {
        return bus;
    }
}
