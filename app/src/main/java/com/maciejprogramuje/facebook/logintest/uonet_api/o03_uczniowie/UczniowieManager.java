package com.maciejprogramuje.facebook.logintest.uonet_api.o03_uczniowie;

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

public class UczniowieManager {
    private final Bus bus;
    private final Certyfikat.TokenCert cert;
    private final ApiUonet apiUonet;

    public UczniowieManager(App app) {
        this.cert = app.getTokenCert();
        bus = app.getBus();
        apiUonet = app.getApiUonet();
    }

    public void generate() {
        String apiUrl = "mobile-api/Uczen.v3.UczenStart/ListaUczniow";

        UczniowieRequest uczniowieRequest = new UczniowieRequest();

        Call<Uczniowie> call = apiUonet.postPupils(apiUrl, uczniowieRequest, ApiGenerator.getHeadersMap(uczniowieRequest, cert));
        call.enqueue(new Callback<Uczniowie>() {
            @Override
            public void onResponse(@NonNull Call<Uczniowie> call, @NonNull Response<Uczniowie> response) {
                if (response.isSuccessful()) {
                    Uczniowie uczniowie = response.body();
                    bus.post(new UczniowieReadyEvent(uczniowie));

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
