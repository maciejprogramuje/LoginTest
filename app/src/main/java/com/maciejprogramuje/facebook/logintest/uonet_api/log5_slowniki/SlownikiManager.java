package com.maciejprogramuje.facebook.logintest.uonet_api.log5_slowniki;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiErrors;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiUonet;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.Slowniki;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.SlownikiRequest;
import com.squareup.otto.Bus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SlownikiManager {
    private final Bus bus;
    private final Certyfikat.TokenCert cert;
    private final ApiUonet apiUonet;
    private String jednostkaSprawozdawczaSymbol;
    private App app;

    public SlownikiManager(App app) {
        this.app = app;
        cert = app.getTokenCert();
        bus = app.getBus();
        apiUonet = app.getApiUonet();
        jednostkaSprawozdawczaSymbol = app.getJednostkaSprawozdawczaSymbol();
    }

    public void generate() {
        String apiUrl = jednostkaSprawozdawczaSymbol + "/mobile-api/Uczen.v3.Uczen/Slowniki";
        SlownikiRequest slownikiRequest = new SlownikiRequest();
        Call<Slowniki> call = apiUonet.postSlowniki(apiUrl, slownikiRequest, ApiGenerator.getHeadersMap(slownikiRequest, cert));
        call.enqueue(new Callback<Slowniki>() {
            @Override
            public void onResponse(@NonNull Call<Slowniki> call, @NonNull Response<Slowniki> response) {
                if (response.isSuccessful()) {
                    Slowniki slowniki = response.body();
                    if (slowniki != null) {
                        app.setSlownik(slowniki.getData());
                        bus.post(new SlownikiReadyEvent());

                        Log.w("UWAGA", "SlownikiRequest sukces -> OK");
                    }
                } else {
                    ApiErrors.show(response);
                }
            }

            @Override
            public void onFailure(Call<Slowniki> call, Throwable t) {
                ApiErrors.show(t);
            }
        });
    }
}
