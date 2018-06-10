package com.maciejprogramuje.facebook.logintest.uonet_api.common;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.squareup.otto.Bus;

public abstract class AbstQManager implements QManager {
    protected String apiUrl;
    protected Bus bus;
    protected Certyfikat.TokenCert cert;
    protected ApiUonet apiUonet;

    public AbstQManager(App app, Certyfikat.TokenCert cert) {
        this.cert = cert;
        bus = app.getBus();
        apiUonet = app.getApiUonet();
    }
}
