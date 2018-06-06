package com.maciejprogramuje.facebook.logintest.uonet_api.pupils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.uonet_api.RetrofitGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.certificate.CertificateSignature;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.UczniowieRequest3;
import com.squareup.otto.Bus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PupilsManager {
    private final Bus bus;
    private final Certyfikat.TokenCert cert;
    private PupilsApi pupilsApi;
    private UczniowieRequest3 uczniowieRequest;

    public PupilsManager(Bus bus, Certyfikat.TokenCert cert) {
        this.bus = bus;
        this.cert = cert;

        generatePupilsApi();
    }

    private void generatePupilsApi() {
        Log.w("UWAGA", "cert.adresBazowyRestApi: " + cert.adresBazowyRestApi);

        RetrofitGenerator pupilsRetrofitGenerator = new RetrofitGenerator(cert.adresBazowyRestApi);
        Retrofit pupilsRetrofit = pupilsRetrofitGenerator.get();
        pupilsApi = pupilsRetrofit.create(PupilsApi.class);
    }

    public void generatePupils() {
        uczniowieRequest = new UczniowieRequest3();
        Call<ResponseBody> call = pupilsApi.postPupils(uczniowieRequest, getPupilsHeadersMap());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                Log.w("UWAGA", "RAW -> " + response.raw());

                if (response.isSuccessful()) {
                    Log.w("UWAGA", "Uczniowie sukces -> OK");

                    /*Uczniowie uczniowie = response.body();
                    Log.w("UWAGA", "Uczniowie sukces -> " + uczniowie.data.get(0).idJednostkaSprawozdawcza);*/

                } else {
                    try {
                        Log.w("UWAGA", "blad 2 - błąd odpowiedzi\n" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
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
        headersMap.put("RequestSignatureValue", CertificateSignature.generate(uczniowieRequest, cert.certyfikatPfx));
        headersMap.put("User-Agent", "MobileUserAgent");
        headersMap.put("Host", "lekcjaplus.vulcan.net.pl");
        headersMap.put("RequestCertificateKey", cert.certyfikatKlucz);
        headersMap.put("Content-Type", "application/json; charset=UTF-8");
        headersMap.put("Cache-Control", "no-cache");

        return headersMap;
    }
}
