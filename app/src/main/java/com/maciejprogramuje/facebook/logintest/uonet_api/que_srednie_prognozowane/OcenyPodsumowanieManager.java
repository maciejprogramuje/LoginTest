package com.maciejprogramuje.facebook.logintest.uonet_api.que_srednie_prognozowane;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiErrors;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.QManagerBase;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.OcenyPodsumowanie;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.OcenyPodsumowanieRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OcenyPodsumowanieManager extends QManagerBase {
    public OcenyPodsumowanieManager(App app) {
        super(app);
    }

    @Override
    public void setUrl() {
        apiUrl = jednostkaSprawozdawczaSymbol + "/mobile-api/Uczen.v3.Uczen/OcenyPodsumowanie";
    }

    @Override
    public void generate() {
        setUrl();

        OcenyPodsumowanieRequest ocenyPodsumowanieRequest = new OcenyPodsumowanieRequest(idOkresKlasyfikacyjny, idUczen);
        Call<OcenyPodsumowanie> call = apiUonet.postOcenyPodsumowanie(apiUrl, ocenyPodsumowanieRequest, ApiGenerator.getHeadersMap(ocenyPodsumowanieRequest, cert));
        call.enqueue(new Callback<OcenyPodsumowanie>() {
            @Override
            public void onResponse(@NonNull Call<OcenyPodsumowanie> call, @NonNull Response<OcenyPodsumowanie> response) {
                if (response.isSuccessful()) {
                    OcenyPodsumowanie body = response.body();
                    Log.w("UWAGA", "OcenyPodsumowanieRequest sukces -> OK");
                    //Log.w("UWAGA", "test: " + body.getData().getSrednieOcen().get(0).getSredniaOcen());

                    bus.post(new OcenyPodsumowanieEvent());
                } else {
                    ApiErrors.show(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<OcenyPodsumowanie> call, @NonNull Throwable t) {
                ApiErrors.show(t);
            }
        });
    }
}