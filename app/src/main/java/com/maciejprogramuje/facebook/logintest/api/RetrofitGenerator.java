package com.maciejprogramuje.facebook.logintest.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.maciejprogramuje.facebook.logintest.MainActivity.SYMBOL;

public class RetrofitGenerator {
    private Retrofit retrofit;
    private String url;

    public RetrofitGenerator(String url) {
        this.url = url;
        generate();
    }

    private void generate() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build();
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create(gson));
        builder.baseUrl(url + SYMBOL);
        builder.client(httpClient);
        retrofit = builder.build();
    }

    public Retrofit get() {
        return retrofit;
    }
}
