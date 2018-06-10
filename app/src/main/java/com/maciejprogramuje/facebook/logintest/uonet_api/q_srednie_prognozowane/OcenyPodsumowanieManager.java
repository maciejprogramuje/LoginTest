package com.maciejprogramuje.facebook.logintest.uonet_api.q_srednie_prognozowane;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiErrors;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.QManagerBase;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.OcenyPodsumowanie;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.OcenyPodsumowanieRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OcenyPodsumowanieManager extends QManagerBase {
    public OcenyPodsumowanieManager(App app, Certyfikat.TokenCert cert) {
        super(app, cert);
    }

    @Override
    public void setUrl() {
        apiUrl = "/mobile-api/Uczen.v3.Uczen/OcenyPodsumowanie";
    }

    @Override
    public void generateOceny(String jednostkaSprawozdawczaSymbol, Integer idOkresKlasyfikacyjny, Integer idUczen) {
        setUrl();
        apiUrl = jednostkaSprawozdawczaSymbol + apiUrl;
        OcenyPodsumowanieRequest ocenyPodsumowanieRequest = new OcenyPodsumowanieRequest(idOkresKlasyfikacyjny, idUczen);
        Call<OcenyPodsumowanie> call = apiUonet.postOcenyPodsumowanie(apiUrl, ocenyPodsumowanieRequest, ApiGenerator.getHeadersMap(ocenyPodsumowanieRequest, cert));
        call.enqueue(new Callback<OcenyPodsumowanie>() {
            @Override
            public void onResponse(@NonNull Call<OcenyPodsumowanie> call, @NonNull Response<OcenyPodsumowanie> response) {
                if (response.isSuccessful()) {
                    //Oceny oceny = response.body();
                    //bus.post(new OcenyReadyEvent(oceny));

                    Log.w("UWAGA", "OcenyPodsumowanieRequest sukces -> OK");
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