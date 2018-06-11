package com.maciejprogramuje.facebook.logintest.uonet_api.q_plan_lekcji;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiErrors;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.QManagerBase;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.PlanLekcjiZeZmianami;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.PlanLekcjiZeZmianamiRequest;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanLekcjiZeZmianamiManager extends QManagerBase {
    public PlanLekcjiZeZmianamiManager(App app) {
        super(app);
    }

    public void setUrl() {
        apiUrl = "/mobile-api/Uczen.v3.Uczen/PlanLekcjiZeZmianami";
    }

    public void generatePlanLekcjiZeZmianami(Date dataPoczatkowa, Date dataKoncowa) {
        setUrl();
        apiUrl = jednostkaSprawozdawczaSymbol + apiUrl;
        PlanLekcjiZeZmianamiRequest planLekcjiZeZmianamiRequest = new PlanLekcjiZeZmianamiRequest(dataPoczatkowa, dataKoncowa, idOkresKlasyfikacyjny, idUczen, idOddzial);
        Call<PlanLekcjiZeZmianami> call = apiUonet.postPlanLekcjiZeZmianami(apiUrl, planLekcjiZeZmianamiRequest, ApiGenerator.getHeadersMap(planLekcjiZeZmianamiRequest, cert));
        call.enqueue(new Callback<PlanLekcjiZeZmianami>() {
            @Override
            public void onResponse(@NonNull Call<PlanLekcjiZeZmianami> call, @NonNull Response<PlanLekcjiZeZmianami> response) {
                if (response.isSuccessful()) {
                    PlanLekcjiZeZmianami body = response.body();
                    Log.w("UWAGA", "PlanLekcjiZeZmianamiRequest sukces -> OK");
                    Log.w("UWAGA", "test: " + body.getData().get(0).toString());

                    //bus.post(new OcenyReadyEvent(oceny));
                } else {
                    ApiErrors.show(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<PlanLekcjiZeZmianami> call, @NonNull Throwable t) {
                ApiErrors.show(t);
            }
        });
    }
}
