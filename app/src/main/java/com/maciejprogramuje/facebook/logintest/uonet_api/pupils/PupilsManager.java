package com.maciejprogramuje.facebook.logintest.uonet_api.pupils;

import com.maciejprogramuje.facebook.logintest.uonet_api.RetrofitGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.certificate.CertificateSignature;
import com.squareup.otto.Bus;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;

public class PupilsManager {
    private final Bus bus;
    private final String baseUrl;
    private final String pfx;
    private final String certficateKey;
    private PupilsApi pupilsApi;
    private PupilsRequest pupilsRequest;

    public PupilsManager(Bus bus, String baseUrl, String pfx, String certficateKey) {
        this.bus = bus;
        this.baseUrl = baseUrl;
        this.pfx = pfx;
        this.certficateKey = certficateKey;

        generatePupilsApi();
    }

    private void generatePupilsApi() {
        RetrofitGenerator pupilsRetrofitGenerator = new RetrofitGenerator(baseUrl);
        Retrofit loginRetrofit = pupilsRetrofitGenerator.get();
        pupilsApi = loginRetrofit.create(PupilsApi.class);
    }

    public void generatePupils() {
        pupilsRequest = new PupilsRequest();
        pupilsApi.postPupils(pupilsRequest, getPupilsHeadersMap());


        /*Call<Uczniowie> call = pupilsApi.postPupils(pupilsRequest, getCertificateHeadersMap());
        call.enqueue(new Callback<Uczniowie>() {
            @Override
            public void onResponse(@NonNull Call<Uczniowie> call, @NonNull Response<Uczniowie> response) {
                if (response.isSuccessful()) {
                    Uczniowie uczniowie = response.body();
                    Log.w("UWAGA", "Uczniowie sukces -> " + uczniowie.toString());

                } else {
                    Log.w("UWAGA", "blad 2 - błąd odpowiedzi");
                }
            }

            @Override
            public void onFailure(Call<Uczniowie> call, Throwable t) {
                if (t instanceof IOException) {
                    Log.w("UWAGA", "blad 3 - błąd połączenia ze stroną lub internetem");
                } else {
                    Log.w("UWAGA", "blad 4 - błąd konwersji odpowiedzi");
                }
            }
        });*/
    }

    private Map<String, String> getPupilsHeadersMap() {
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("RequestSignatureValue", CertificateSignature.generate(pupilsRequest, pfx));
        headersMap.put("User-Agent", "MobileUserAgent");
        headersMap.put("Host", "lekcjaplus.vulcan.net.pl");
        headersMap.put("RequestCertificateKey", certficateKey);
        headersMap.put("Content-Type", "application/json; charset=UTF-8");

        return headersMap;
    }
}
