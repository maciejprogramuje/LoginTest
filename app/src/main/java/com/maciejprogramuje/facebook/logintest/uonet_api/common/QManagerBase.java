package com.maciejprogramuje.facebook.logintest.uonet_api.common;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.Certyfikat;
import com.squareup.otto.Bus;

public abstract class QManagerBase {
    protected String apiUrl;
    protected Bus bus;
    protected Certyfikat.TokenCert cert;
    protected ApiUonet apiUonet;
    protected String jednostkaSprawozdawczaSymbol;
    protected Integer idOkresKlasyfikacyjny;
    protected Integer idUczen;
    protected Integer idOddzial;
    protected App app;

    public QManagerBase(App app) {
        this.app = app;
        cert = app.getTokenCert();
        bus = app.getBus();
        apiUonet = app.getApiUonet();
        jednostkaSprawozdawczaSymbol = app.getJednostkaSprawozdawczaSymbol();
        idOkresKlasyfikacyjny = app.getIdOkresKlasyfikacyjny();
        idUczen = app.getIdUczen();
        idOddzial = app.getIdOddzial();
    }

    public abstract void setUrl();

    public abstract void generate();
}
