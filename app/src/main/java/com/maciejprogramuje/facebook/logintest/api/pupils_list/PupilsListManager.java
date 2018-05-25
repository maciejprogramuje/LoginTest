package com.maciejprogramuje.facebook.logintest.api.pupils_list;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.RetrofitGenerator;
import com.maciejprogramuje.facebook.logintest.api.pupils_list.models.PupilsListRequest;
import com.squareup.otto.Bus;

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
    private String baseUrl;
    private final String requestSignature;
    private final String certificateKey;
    private PupilsListApi pupilsListApi;

    public PupilsListManager(Bus bus, String baseUrl, String requestSignature, String certificateKey) {
        this.bus = bus;
        this.baseUrl = baseUrl;
        this.requestSignature = requestSignature;
        this.certificateKey = certificateKey;

        generatePupilsListApi();
        generatePupilsList();
    }

    private void generatePupilsListApi() {
        RetrofitGenerator pupilsListRetrofitGenerator = new RetrofitGenerator(baseUrl);
        Retrofit pupilsListRetrofit = pupilsListRetrofitGenerator.get();
        pupilsListApi = pupilsListRetrofit.create(PupilsListApi.class);
    }

    private void generatePupilsList() {
        PupilsListRequest pupilsListRequest = new PupilsListRequest();
        Call<ResponseBody> call = pupilsListApi.postPupilsList(pupilsListRequest, getPupilsListHeadersMap());
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
        headersMap.put("RequestSignatureValue", requestSignature);
        headersMap.put("User-Agent", "MobileUserAgent");
        headersMap.put("RequestCertificateKey", certificateKey);
        headersMap.put("Content-Type", "application/json; charset=UTF-8");
        return headersMap;
    }
}
