package com.maciejprogramuje.facebook.logintest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.maciejprogramuje.facebook.logintest.api.base_url.BaseUrlManager;
import com.maciejprogramuje.facebook.logintest.api.base_url.BaseUrlReadyEvent;
import com.maciejprogramuje.facebook.logintest.api.certificate.CertificateManager;
import com.maciejprogramuje.facebook.logintest.api.certificate.CertyfikatReadyEvent;
import com.maciejprogramuje.facebook.logintest.api.certificate.models.CertificateResponse;
import com.maciejprogramuje.facebook.logintest.api.pupils_list.PupilsListManager;
import com.maciejprogramuje.facebook.logintest.api.pupils_list.PupilsListReadyEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.maciejprogramuje.facebook.logintest.App.BASE_URL_KEY;
import static com.maciejprogramuje.facebook.logintest.App.CERTIFICATE_KEY;

public class MainActivity extends AppCompatActivity {
    public static final String TOKEN = "3S1FM2U1";
    public static final String SYMBOL = "lublin";
    public static final String PIN = "053792";

    @BindView(R.id.statusTextView)
    TextView statusTextView;
    @BindView(R.id.loginButton)
    Button loginButton;

    private Bus bus;
    private String baseUrl;
    private App app;
    private CertificateResponse.Certyfikat certificate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        app = (App) getApplication();
        bus = app.getBus();

        baseUrl = app.getSharedPreferences().getString(BASE_URL_KEY, "");

        Gson gson = new Gson();
        String json = app.getSharedPreferences().getString("SerializableObject", "");
        certificate = gson.fromJson(json, CertificateResponse.Certyfikat.class);

        if(baseUrl.isEmpty() || json.isEmpty()) {
            loginButton.setEnabled(true);
        } else {
            loginButton.setEnabled(false);
            //TODO
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        bus.unregister(this);
    }

    @OnClick(R.id.loginButton)
    public void onLoginButtonClicked() {
        BaseUrlManager baseUrlManager = new BaseUrlManager(TOKEN, bus);
        baseUrlManager.postBaseUrlEvent();
    }

    @Subscribe
    public void onBaseUrlReady(BaseUrlReadyEvent event) {
        baseUrl = event.getBaseUrl();
        app.getSharedPreferences().edit().putString(BASE_URL_KEY, baseUrl).apply();

        CertificateManager certificateManager = new CertificateManager(baseUrl, bus);
    }

    @Subscribe
    public void onCertificateReady(CertyfikatReadyEvent event) {
        certificate = event.getCertificate();

        SharedPreferences.Editor preferencesEditor = app.getSharedPreferences().edit();
        Gson gson = new Gson();
        String json = gson.toJson(certificate);
        preferencesEditor.putString(CERTIFICATE_KEY, json);
        preferencesEditor.apply();

        String requestSignature = event.getRequestSignature();

        PupilsListManager pupilsListManager = new PupilsListManager(bus, baseUrl, requestSignature, certificate.getCertyfikatKlucz());

        statusTextView.setText(String.format("OK\n\n%s", event.getCertificate().getUzytkownikLogin()));
    }

    @Subscribe
    public void onPupilsListReady(PupilsListReadyEvent event) {
        statusTextView.setText(statusTextView.getText() + "\n\nPupilsList - OK!");
    }
}
