package com.maciejprogramuje.facebook.logintest.api.login;

import android.support.annotation.NonNull;
import android.util.Log;

import com.maciejprogramuje.facebook.logintest.RetrofitGenerator;
import com.maciejprogramuje.facebook.logintest.api.login.models.CertificateBody;
import com.maciejprogramuje.facebook.logintest.api.login.models.CertificateRequest;
import com.squareup.otto.Bus;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.maciejprogramuje.facebook.logintest.MainActivity.PIN;
import static com.maciejprogramuje.facebook.logintest.MainActivity.TOKEN;

public class LoginManager {
    private final String baseUrl;
    private final Bus bus;
    private Call<CertificateBody> call;
    private CertificateBody.Certyfikat certyfikat;
    private CertificateRequest certificateRequest;

    public LoginManager(String baseUrl, Bus bus) {
        this.baseUrl = baseUrl;
        this.bus = bus;

        generate();
    }

    private void generate() {
        certificateRequest = new CertificateRequest(PIN, TOKEN);

        RetrofitGenerator loginRetrofitGenerator = new RetrofitGenerator(baseUrl);
        Retrofit loginRetrofit = loginRetrofitGenerator.get();
        final LoginApi loginApi = loginRetrofit.create(LoginApi.class);

        call = loginApi.postLogin(certificateRequest);
    }

    public void postCertificateEvent() {
        call.enqueue(new Callback<CertificateBody>() {
            @Override
            public void onResponse(@NonNull Call<CertificateBody> call, @NonNull Response<CertificateBody> response) {
                if (response.isSuccessful()) {
                    CertificateBody certificateBody = response.body();
                    if (!certificateBody.getError()) {
                        certyfikat = certificateBody.getTokenCert();
                        bus.post(new CertyfikatReadyEvent(certyfikat, certificateRequest));
                    } else {
                        Log.w("UWAGA", "blad 1 - błędny lub przeterminowany PIN lub TOKEN");
                    }
                } else {
                    Log.w("UWAGA","blad 2 - błąd odpowiedzi");
                }
            }

            @Override
            public void onFailure(Call<CertificateBody> call, Throwable t) {
                if (t instanceof IOException) {
                    Log.w("UWAGA","blad 3 - błąd połączenia ze stroną lub internetem");
                } else {
                    Log.w("UWAGA","blad 4 - błąd konwersji odpowiedzi");
                }
            }
        });
    }

    public CertificateBody.Certyfikat getCertyfikat() {
        return certyfikat;
    }

    public CertificateRequest getCertificateRequest() {
        return certificateRequest;
    }
}
