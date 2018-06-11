package com.maciejprogramuje.facebook.logintest.uonet_api.o02_certyfikat;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiErrors;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiUonet;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.CertyfikatRequest;
import com.squareup.otto.Bus;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CertyfikatManager {
    private String apiUrl = "mobile-api/Uczen.v3.UczenStart/Certyfikat";
    private Certyfikat.TokenCert tokenCert;
    private ApiUonet apiUonet;
    private final Bus bus;

    public CertyfikatManager(App app) {
        bus = app.getBus();
        apiUonet = app.getApiUonet();
    }

    public void generate(String pin, String token) {
        CertyfikatRequest certyfikatRequest = new CertyfikatRequest(pin, token);
        Call<Certyfikat> call = apiUonet.postCerificate(apiUrl, certyfikatRequest, getCertificateHeadersMap());
        call.enqueue(new Callback<Certyfikat>() {
            @Override
            public void onResponse(@NonNull Call<Certyfikat> call, @NonNull Response<Certyfikat> response) {
                if (response.isSuccessful()) {
                    Certyfikat certyfikat = response.body();

                    if (certyfikat.getTokenCert() != null) {
                        tokenCert = certyfikat.getTokenCert();
                        bus.post(new CertyfikatReadyEvent(tokenCert.getCertyfikatPfx(), tokenCert.getCertyfikatKlucz()));
                    } else {
                        Log.w("UWAGA", "blad 1 - błędny lub przeterminowany PIN lub TOKEN -> " + certyfikat.toString());
                    }
                } else {
                    ApiErrors.show(response);
                }
            }

            @Override
            public void onFailure(Call<Certyfikat> call, Throwable t) {
                ApiErrors.show(t);
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
