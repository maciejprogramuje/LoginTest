package com.maciejprogramuje.facebook.logintest.uonet_api.base_url;

import android.support.annotation.NonNull;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.RetrofitGenerator;
import com.squareup.otto.Bus;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.maciejprogramuje.facebook.logintest.MainActivity.SYMBOL;

public class BaseUrlManager {
    private String shortToken;
    private Bus bus;
    private Call<ResponseBody> call;
    private BaseUrlApi baseUrlApi;

    public BaseUrlManager(String token, App app) {
        this.shortToken = token.substring(0, 3);
        this.bus = app.getBus();
    }

    public void generateBaseUrl() {
        generateBaseUrlApi();

        call = baseUrlApi.getBaseUrl();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        String rawBody = response.body().string();
                        String baseUrl = rawBody.substring(rawBody.indexOf(shortToken) + 4);
                        baseUrl = baseUrl.substring(0, baseUrl.indexOf("\n") - 1) + "/" + SYMBOL + "/";

                        bus.post(new BaseUrlReadyEvent(baseUrl));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void generateBaseUrlApi() {
        RetrofitGenerator baseUrlRetrofitGenerator = new RetrofitGenerator("http://komponenty.vulcan.net.pl");
        Retrofit baseUrlRetrofit = baseUrlRetrofitGenerator.get();
        baseUrlApi = baseUrlRetrofit.create(BaseUrlApi.class);
    }
}
