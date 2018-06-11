package com.maciejprogramuje.facebook.logintest.uonet_api.o05_slowniki;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiErrors;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiUonet;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Slowniki;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.SlownikiRequest;
import com.squareup.otto.Bus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SlownikiManager {
    private String apiUrl = "/mobile-api/Uczen.v3.Uczen/Slowniki";
    private final Bus bus;
    private final Certyfikat.TokenCert cert;
    private final ApiUonet apiUonet;
    private String jednostkaSprawozdawczaSymbol;

    public SlownikiManager(App app) {
        this.cert = app.getTokenCert();
        bus = app.getBus();
        apiUonet = app.getApiUonet();
        jednostkaSprawozdawczaSymbol = app.getJednostkaSprawozdawczaSymbol();
    }

    public void generateSlowniki() {
        apiUrl = jednostkaSprawozdawczaSymbol + apiUrl;
        SlownikiRequest slownikiRequest = new SlownikiRequest();
        Call<Slowniki> call = apiUonet.postSlowniki(apiUrl, slownikiRequest, ApiGenerator.getHeadersMap(slownikiRequest, cert));
        call.enqueue(new Callback<Slowniki>() {
            @Override
            public void onResponse(@NonNull Call<Slowniki> call, @NonNull Response<Slowniki> response) {
                if (response.isSuccessful()) {
                    Slowniki slowniki = response.body();
                    bus.post(new SlownikiReadyEvent(slowniki));

                    Log.w("UWAGA", "SlownikiRequest sukces -> OK");
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
