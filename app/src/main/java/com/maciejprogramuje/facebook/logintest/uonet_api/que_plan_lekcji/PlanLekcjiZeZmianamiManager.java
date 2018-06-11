package com.maciejprogramuje.facebook.logintest.uonet_api.que_plan_lekcji;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiErrors;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.QManagerBase;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.PlanLekcjiZeZmianami;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.PlanLekcjiZeZmianamiRequest;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanLekcjiZeZmianamiManager extends QManagerBase {
    private final Date dataPoczatkowa;
    private final Date dataKoncowa;

    public PlanLekcjiZeZmianamiManager(App app, Date dataPoczatkowa, Date dataKoncowa) {
        super(app);
        this.dataPoczatkowa = dataPoczatkowa;
        this.dataKoncowa = dataKoncowa;
    }

    @Override
    public void setUrl() {
        apiUrl = jednostkaSprawozdawczaSymbol + "/mobile-api/Uczen.v3.Uczen/PlanLekcjiZeZmianami";
    }

    @Override
    public void generate() {
        setUrl();

        PlanLekcjiZeZmianamiRequest planLekcjiZeZmianamiRequest = new PlanLekcjiZeZmianamiRequest(dataPoczatkowa, dataKoncowa, idOkresKlasyfikacyjny, idUczen, idOddzial);
        Call<PlanLekcjiZeZmianami> call = apiUonet.postPlanLekcjiZeZmianami(apiUrl, planLekcjiZeZmianamiRequest, ApiGenerator.getHeadersMap(planLekcjiZeZmianamiRequest, cert));
        call.enqueue(new Callback<PlanLekcjiZeZmianami>() {
            @Override
            public void onResponse(@NonNull Call<PlanLekcjiZeZmianami> call, @NonNull Response<PlanLekcjiZeZmianami> response) {
                if (response.isSuccessful()) {
                    PlanLekcjiZeZmianami body = response.body();
                    Log.w("UWAGA", "PlanLekcjiRequest sukces -> OK");
                    Log.w("UWAGA", "test: " + body.getData().get(0).toString());

                    bus.post(new PlanLekcjiZeZmianamiReadyEvent());
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
