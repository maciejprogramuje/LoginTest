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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UczniowieManager {
    private final Bus bus;
    private final Certyfikat.TokenCert cert;
    private final ApiUonet apiUonet;
    private App app;

    public UczniowieManager(App app) {
        this.app = app;
        cert = app.getTokenCert();
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
                    //todo - tu dodac,ktorego ucznia dane ma wyswietlac
                    List<Uczniowie.Uczen> uczniowie = response.body().getData();
                    Uczniowie.Uczen uczen = uczniowie.get(1);

                    app.setJednostkaSprawozdawczaSymbol(uczen.getJednostkaSprawozdawczaSymbol());
                    app.setIdOkresKlasyfikacyjny(uczen.getIdOkresKlasyfikacyjny());
                    app.setIdUczen(uczen.getId());
                    app.setIdOddzial(uczen.getIdOddzial());

                    bus.post(new UczniowieReadyEvent());

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
