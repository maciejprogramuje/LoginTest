package com.maciejprogramuje.facebook.logintest.uonet_api.pupils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.uonet_api.RetrofitGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.certificate.CertificateSignature;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.UczniowieRequest3;
import com.squareup.otto.Bus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PupilsManager {
    private final Bus bus;
    private final String baseUrl;
    private final String pfx;
    private final String certficateKey;
    private PupilsApi pupilsApi;
    private UczniowieRequest3 uczniowieRequest3;

    public PupilsManager(Bus bus, String baseUrl, String pfx, String certficateKey) {
        this.bus = bus;
        this.baseUrl = baseUrl;
        this.pfx = pfx;
        this.certficateKey = certficateKey;

        generatePupilsApi();
    }

    private void generatePupilsApi() {
        RetrofitGenerator pupilsRetrofitGenerator = new RetrofitGenerator(baseUrl);
        Retrofit pupilsRetrofit = pupilsRetrofitGenerator.get();
        pupilsApi = pupilsRetrofit.create(PupilsApi.class);
    }

    public void generatePupils() {
        uczniowieRequest3 = new UczniowieRequest3();
        Call<Void> call = pupilsApi.postPupils(uczniowieRequest3, getPupilsHeadersMap());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (response.isSuccessful()) {
                    //Uczniowie uczniowie = response.body();
                    //Log.w("UWAGA", "Uczniowie sukces -> " + uczniowie.toString());

                } else {
                    try {
                        Log.w("UWAGA", "blad 2 - błąd odpowiedzi\n"+response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                if (t instanceof IOException) {
                    Log.w("UWAGA", "blad 3 - błąd połączenia ze stroną lub internetem");
                } else {
                    Log.w("UWAGA", "blad 4 - błąd konwersji odpowiedzi");
                }
            }
        });
    }

    private Map<String, String> getPupilsHeadersMap() {
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("RequestSignatureValue", CertificateSignature.generate(uczniowieRequest3, pfx));
        headersMap.put("User-Agent", "MobileUserAgent");
        headersMap.put("Host", "lekcjaplus.vulcan.net.pl");
        headersMap.put("RequestCertificateKey", certficateKey);
        headersMap.put("Content-Type", "application/json; charset=UTF-8");

        return headersMap;
    }
}
