package com.maciejprogramuje.facebook.logintest.uonet_api.que_oceny;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiErrors;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.QManagerBase;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.Oceny;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.OcenyRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OcenyManager extends QManagerBase {
    public OcenyManager(App app) {
        super(app);
    }

    @Override
    public void setUrl() {
        apiUrl = jednostkaSprawozdawczaSymbol + "/mobile-api/Uczen.v3.Uczen/Oceny";
    }

    @Override
    public void generate() {
        setUrl();

        OcenyRequest ocenyRequest = new OcenyRequest(idOkresKlasyfikacyjny, idUczen);
        Call<Oceny> call = apiUonet.postOceny(apiUrl, ocenyRequest, ApiGenerator.getHeadersMap(ocenyRequest, cert));
        call.enqueue(new Callback<Oceny>() {
            @Override
            public void onResponse(@NonNull Call<Oceny> call, @NonNull Response<Oceny> response) {
                if (response.isSuccessful()) {
                    //todo - przekazac do ocen slownik? dodac gettery zwracajace nazwiska itp?
                    Oceny oceny = response.body();
                    if (oceny != null) {
                        app.setOceny(oceny.getData());
                        bus.post(new OcenyReadyEvent(oceny));

                        Log.w("UWAGA", "OcenyRequest sukces -> OK");
                    }
                } else {
                    ApiErrors.show(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Oceny> call, @NonNull Throwable t) {
                ApiErrors.show(t);
            }
        });
    }
}
