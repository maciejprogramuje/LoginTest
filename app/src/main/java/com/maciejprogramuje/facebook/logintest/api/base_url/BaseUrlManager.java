package com.maciejprogramuje.facebook.logintest.api.base_url;

import android.support.annotation.NonNull;

import com.maciejprogramuje.facebook.logintest.RetrofitGenerator;
import com.squareup.otto.Bus;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BaseUrlManager {
    private String shortToken;
    private Bus bus;
    private Call<ResponseBody> call;

    public BaseUrlManager(String token, Bus bus) {
        this.shortToken = token.substring(0, 3);
        this.bus = bus;

        generate();
    }

    private void generate() {
        RetrofitGenerator baseUrlRetrofitGenerator = new RetrofitGenerator("http://komponenty.vulcan.net.pl");
        Retrofit baseUrlRetrofit = baseUrlRetrofitGenerator.get();
        final BaseUrlApi baseUrlApi = baseUrlRetrofit.create(BaseUrlApi.class);

        call = baseUrlApi.getBaseUrl();
    }

    public void postBaseUrlEvent() {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                try {
                    if (response.body() != null) {
                        String rawBody = response.body().string();
                        String baseUrl = rawBody.substring(rawBody.indexOf(shortToken) + 4);
                        baseUrl = baseUrl.substring(0, baseUrl.indexOf("\n"));

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
}
