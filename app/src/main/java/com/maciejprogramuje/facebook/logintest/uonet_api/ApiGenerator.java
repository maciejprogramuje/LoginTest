package com.maciejprogramuje.facebook.logintest.uonet_api;

import com.maciejprogramuje.facebook.logintest.App;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiGenerator {
    public static void generateAndAddToApp(App app, String url) {
        app.setUonetApi(generate(url));
    }

    public static UonetApi generate(String url) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        //Gson gson = new GsonBuilder().setLenient().create();

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(url)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient);

        Retrofit retrofit = builder.build();
        UonetApi uonetApi = retrofit.create(UonetApi.class);

        return uonetApi;
    }
}
