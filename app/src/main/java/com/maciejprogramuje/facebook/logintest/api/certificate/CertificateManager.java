package com.maciejprogramuje.facebook.logintest.api.certificate;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.CertificateSignature;
import com.maciejprogramuje.facebook.logintest.RetrofitGenerator;
import com.maciejprogramuje.facebook.logintest.api.certificate.models.CertificateRequest;
import com.maciejprogramuje.facebook.logintest.api.certificate.models.CertificateResponse;
import com.squareup.otto.Bus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.maciejprogramuje.facebook.logintest.MainActivity.PIN;
import static com.maciejprogramuje.facebook.logintest.MainActivity.TOKEN;

public class CertificateManager {
    private final String baseUrl;
    private final Bus bus;
    private CertificateResponse.Certyfikat cerificate;
    private CertificateRequest certificateRequest;
    private CertificateApi certificateApi;

    public CertificateManager(String baseUrl, Bus bus) {
        this.baseUrl = baseUrl;
        this.bus = bus;

        generateLoginApi();
        generateCerificate();
    }

    private void generateLoginApi() {
        RetrofitGenerator loginRetrofitGenerator = new RetrofitGenerator(baseUrl);
        Retrofit loginRetrofit = loginRetrofitGenerator.get();
        certificateApi = loginRetrofit.create(CertificateApi.class);
    }

    private void generateCerificate() {
        certificateRequest = new CertificateRequest(PIN, TOKEN);
        Call<CertificateResponse> call = certificateApi.postCerificate(certificateRequest, getCertificateHeadersMap());
        call.enqueue(new Callback<CertificateResponse>() {
            @Override
            public void onResponse(@NonNull Call<CertificateResponse> call, @NonNull Response<CertificateResponse> response) {
                if (response.isSuccessful()) {
                    CertificateResponse certificateResponse = response.body();
                    if (!certificateResponse.getError()) {
                        cerificate = certificateResponse.getTokenCert();
                        bus.post(new CertyfikatReadyEvent(cerificate, CertificateSignature.generate(certificateRequest, cerificate)));
                    } else {
                        Log.w("UWAGA", "blad 1 - błędny lub przeterminowany PIN lub TOKEN");
                    }
                } else {
                    Log.w("UWAGA", "blad 2 - błąd odpowiedzi");
                }
            }

            @Override
            public void onFailure(Call<CertificateResponse> call, Throwable t) {
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
