package com.maciejprogramuje.facebook.logintest.uonet_api.log1_base_url;

import android.support.annotation.NonNull;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiErrors;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiUonet;
import com.squareup.otto.Bus;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseUrlManager {
    private String shortToken;
    private String token;
    private Bus bus;
    private String symbol;
    private String pin;

    public BaseUrlManager(App app, String pin, String symbol, String token) {
        this.token = token;
        this.shortToken = token.substring(0, 3);
        this.bus = app.getBus();
        this.symbol = symbol;
        this.pin = pin;
    }

    public void generateBaseUrl() {
        ApiUonet baseUrlApi = ApiGenerator.generate("http://komponenty.vulcan.net.pl/");

        Call<ResponseBody> call = baseUrlApi.getBaseUrl("UonetPlusMobile/RoutingRules.txt");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        String rawBody = response.body().string();
                        //todo - problemy z pkcs12 wynikają z błędnego url - np. poniżej łapał się przecinek i psuł
                        String baseUrl = rawBody.substring(rawBody.indexOf(shortToken) + 5);
                        baseUrl = baseUrl.substring(0, baseUrl.indexOf(".pl") + 3) + "/" + symbol + "/";

                        bus.post(new BaseUrlReadyEvent(baseUrl, pin, token));
                    }
                } catch (IOException e) {
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
