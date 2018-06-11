package com.maciejprogramuje.facebook.logintest.uonet_api.common;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.RequestBase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiGenerator {
    public static void generateAndSetBaseUrl(App app, String url) {
        app.setApiUonet(generate(url));
    }

    public static ApiUonet generate(String url) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(url)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient);

        Retrofit retrofit = builder.build();

        return retrofit.create(ApiUonet.class);
    }

    public static Map<String, String> getHeadersMap(RequestBase request, Certyfikat.TokenCert cert) {
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("RequestSignatureValue", CertificateSignature.generate(request, cert.getCertyfikatPfx()));
        headersMap.put("User-Agent", "MobileUserAgent");
        headersMap.put("Host", "lekcjaplus.vulcan.net.pl");
        headersMap.put("RequestCertificateKey", cert.getCertyfikatKlucz());
        headersMap.put("Content-Type", "application/json; charset=UTF-8");
        headersMap.put("Cache-Control", "no-cache");

        return headersMap;
    }
}
