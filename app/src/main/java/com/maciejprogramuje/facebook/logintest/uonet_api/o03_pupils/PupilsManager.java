package com.maciejprogramuje.facebook.logintest.uonet_api.o03_pupils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiErrors;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiUonet;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Uczniowie;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.UczniowieRequest;
import com.squareup.otto.Bus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PupilsManager {
    private String apiUrl = "mobile-api/Uczen.v3.UczenStart/ListaUczniow";
    private final Bus bus;
    private final Certyfikat.TokenCert cert;
    private UczniowieRequest uczniowieRequest;
    private final ApiUonet apiUonet;

    public PupilsManager(App app) {
        this.cert = app.getTokenCert();
        bus = app.getBus();
        apiUonet = app.getApiUonet();
    }

    public void generatePupils() {
        uczniowieRequest = new UczniowieRequest();

        Call<Uczniowie> call = apiUonet.postPupils(apiUrl, uczniowieRequest, ApiGenerator.getHeadersMap(uczniowieRequest, cert));
        call.enqueue(new Callback<Uczniowie>() {
            @Override
            public void onResponse(@NonNull Call<Uczniowie> call, @NonNull Response<Uczniowie> response) {
                if (response.isSuccessful()) {
                    Uczniowie uczniowie = response.body();
                    bus.post(new PupilsReadyEvent(uczniowie));

                    Log.w("UWAGA", "Uczniowie sukces -> OK");
                } else {
                    ApiErrors.show(response);
                }
            }

            @Override
            public void onFailure(Call<Uczniowie> call, Throwable t) {
                ApiErrors.show(t);
            }
        });
    }
}
