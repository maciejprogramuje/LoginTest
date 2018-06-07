package com.maciejprogramuje.facebook.logintest.uonet_api.certificate;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.ApiUonet;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.CertyfikatRequest;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.RequestAbst;
import com.squareup.otto.Bus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CertificateManager {
    private String apiUrl = "mobile-api/Uczen.v3.UczenStart/Certyfikat";
    private Certyfikat.TokenCert tokenCert;
    private ApiUonet apiUonet;
    private final Bus bus;

    public CertificateManager(App app) {
        bus = app.getBus();
        apiUonet = app.getApiUonet();
    }

    public void generateCerificate(String pin, String token) {
        RequestAbst certyfikatRequest = new CertyfikatRequest(pin, token);
        Call<Certyfikat> call = apiUonet.postCerificate(apiUrl, certyfikatRequest, getCertificateHeadersMap());
        call.enqueue(new Callback<Certyfikat>() {
            @Override
            public void onResponse(@NonNull Call<Certyfikat> call, @NonNull Response<Certyfikat> response) {
                if (response.isSuccessful()) {
                    Certyfikat certyfikat = response.body();

                    if (certyfikat.getTokenCert() != null) {
                        tokenCert = certyfikat.getTokenCert();
                        bus.post(new CertificateReadyEvent(tokenCert.getCertyfikatPfx(), tokenCert.getCertyfikatKlucz()));
                    } else {
                        Log.w("UWAGA", "blad 1 - błędny lub przeterminowany PIN lub TOKEN -> " + certyfikat.toString());
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
        headersMap.put("Cache-Control", "no-cache");

        return headersMap;
    }
}
