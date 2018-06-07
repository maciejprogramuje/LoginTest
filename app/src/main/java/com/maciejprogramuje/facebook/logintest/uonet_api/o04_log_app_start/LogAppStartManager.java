package com.maciejprogramuje.facebook.logintest.uonet_api.o04_log_app_start;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiErrors;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiUonet;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.LogAppStartRequest;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.RequestAbst;
import com.squareup.otto.Bus;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogAppStartManager {
    private String apiUrl = "/mobile-api/Uczen.v3.Uczen/LogAppStart";
    private final Bus bus;
    private final Certyfikat.TokenCert cert;
    private RequestAbst logAppStartRequest;
    private final ApiUonet apiUonet;

    public LogAppStartManager(App app, Certyfikat.TokenCert cert) {
        this.cert = cert;
        bus = app.getBus();
        apiUonet = app.getApiUonet();
    }

    public void generateLogAppStart(String jednostkaSprawozdawczaSymbol) {
        apiUrl = jednostkaSprawozdawczaSymbol + apiUrl;
        logAppStartRequest = new LogAppStartRequest();
        Call<ResponseBody> call = apiUonet.postLogAppStart(apiUrl, logAppStartRequest, ApiGenerator.getHeadersMap(logAppStartRequest, cert));
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    bus.post(new LogAppStartReadyEvent());

                    Log.w("UWAGA", "LogAppStartRequest sukces -> OK");
                } else {
                    ApiErrors.show(response);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                ApiErrors.show(t);
            }
        });
    }
}
