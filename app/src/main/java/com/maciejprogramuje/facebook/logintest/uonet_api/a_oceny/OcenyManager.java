package com.maciejprogramuje.facebook.logintest.uonet_api.a_oceny;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiErrors;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiUonet;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.OcenyRequest;
import com.squareup.otto.Bus;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OcenyManager {
    private String apiUrl = "/mobile-api/Uczen.v3.Uczen/Oceny";
    private final Bus bus;
    private final Certyfikat.TokenCert cert;
    private final ApiUonet apiUonet;

    public OcenyManager(App app, Certyfikat.TokenCert cert) {
        this.cert = cert;
        bus = app.getBus();
        apiUonet = app.getApiUonet();
    }

    public void generateOceny(String jednostkaSprawozdawczaSymbol, Integer idOkresKlasyfikacyjny, Integer idUczen) {
        apiUrl = jednostkaSprawozdawczaSymbol + apiUrl;
        OcenyRequest ocenyRequest = new OcenyRequest(idOkresKlasyfikacyjny, idUczen);
        Call<ResponseBody> call = apiUonet.postOceny(apiUrl, ocenyRequest, ApiGenerator.getHeadersMap(ocenyRequest, cert));
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if(response.isSuccessful()) {
                    //todo - oceny response
                    bus.post(new OcenyReadyEvent());

                    Log.w("UWAGA", "OcenyRequest sukces -> OK");
                } else {
                    ApiErrors.show(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                ApiErrors.show(t);
            }
        });
    }
}
