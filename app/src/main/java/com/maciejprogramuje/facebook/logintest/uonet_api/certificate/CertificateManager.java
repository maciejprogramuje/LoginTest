package com.maciejprogramuje.facebook.logintest.uonet_api.certificate;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.uonet_api.RetrofitGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.CertyfikatRequest;
import com.squareup.otto.Bus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class CertificateManager {
    private final String baseUrl;
    private final Bus bus;
    private Certyfikat.TokenCertificate tokenCertificate;
    private CertificateApi certificateApi;

    public CertificateManager(String baseUrl, Bus bus) {
        this.baseUrl = baseUrl;
        this.bus = bus;

        generateLoginApi();
    }

    private void generateLoginApi() {
        RetrofitGenerator loginRetrofitGenerator = new RetrofitGenerator(baseUrl);
        Retrofit loginRetrofit = loginRetrofitGenerator.get();
        certificateApi = loginRetrofit.create(CertificateApi.class);
    }

    public void generateCerificate(String pin, String token) {
        CertyfikatRequest certyfikatRequest = new CertyfikatRequest(pin, token);
        Call<Certyfikat> call = certificateApi.postCerificate(certyfikatRequest, getCertificateHeadersMap());
        call.enqueue(new Callback<Certyfikat>() {
            @Override
            public void onResponse(@NonNull Call<Certyfikat> call, @NonNull Response<Certyfikat> response) {
                if (response.isSuccessful()) {
                    Certyfikat certyfikat = response.body();
                    if (!certyfikat.getError()) {
                        tokenCertificate = certyfikat.getTokenCert();
                        bus.post(new CertificateReadyEvent(tokenCertificate));
                    } else {
                        Log.w("UWAGA", "blad 1 - błędny lub przeterminowany PIN lub TOKEN");
                    }
                } else {
                    Log.w("UWAGA", "blad 2 - błąd odpowiedzi");
                }
            }

            @Override
            public void onFailure(Call<Certyfikat> call, Throwable t) {
                if (t instanceof IOException) {
                    Log.w("UWAGA", "blad 3 - błąd połączenia ze stroną lub internetem");
                } else {
                    Log.w("UWAGA", "blad 4 - błąd konwersji odpowiedzi");
                }
            }
        });
    }

    private Map<String, String> getCertificateHeadersMap() {
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("RequestMobileType", "RegisterDevice");
        headersMap.put("User-Agent", "MobileUserAgent");
        headersMap.put("Content-Type", "application/json");
        return headersMap;
    }
}
