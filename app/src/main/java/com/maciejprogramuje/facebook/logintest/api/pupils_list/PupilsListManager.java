package com.maciejprogramuje.facebook.logintest.api.pupils_list;

import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.CertificateSignature;
import com.maciejprogramuje.facebook.logintest.RetrofitGenerator;
import com.maciejprogramuje.facebook.logintest.api.models.UczniowieRequest;
import com.squareup.otto.Bus;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PupilsListManager {
    private Bus bus;
    private App app;
    private PupilsListApi pupilsListApi;
    private UczniowieRequest uczniowieRequest;

    public PupilsListManager(Bus bus, App app) {
        this.bus = bus;
        this.app = app;

        generatePupilsListApi();
        generatePupilsList();
    }

    private void generatePupilsListApi() {
        RetrofitGenerator pupilsListRetrofitGenerator = new RetrofitGenerator(app.getBaseUrl());
        Retrofit pupilsListRetrofit = pupilsListRetrofitGenerator.get();
        pupilsListApi = pupilsListRetrofit.create(PupilsListApi.class);
    }

    private void generatePupilsList() {
        uczniowieRequest = new UczniowieRequest();
        Call<ResponseBody> call = pupilsListApi.postPupilsList(uczniowieRequest, getPupilsListHeadersMap());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        if(response.body() != null) {
                            Log.w("UWAGA", "======================================================== OK ========================================================");
                            Log.w("UWAGA", response.body().string());
                            bus.post(new PupilsListReadyEvent());
                        } else {
                            Log.w("UWAGA", "======================================================== PROBLEM 1 ========================================================");
                            Log.w("UWAGA", "response.body() == NULL");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.w("UWAGA", "======================================================== PROBLEM 2 ========================================================");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private Map<String, String> getPupilsListHeadersMap() {
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("Host", "lekcjaplus.vulcan.net.pl");
        headersMap.put("Content-Type", "application/json");
        headersMap.put("User-Agent", "MobileUserAgent");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            byte[] bytes = mapper.writeValueAsBytes(uczniowieRequest);
            headersMap.put("RequestSignatureValue", CertificateSignature.generate(bytes, new ByteArrayInputStream(Base64.decode(app.getPfx(), Base64.NO_WRAP))));
            headersMap.put("RequestCertificateKey", app.getCertificateKey());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return headersMap;
    }
}
