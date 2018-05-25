package com.maciejprogramuje.facebook.logintest;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity {
    public static final String TOKEN = "3S1MB069";
    public static final String SYMBOL = "lublin";
    public static final String PIN = "389012";

    @BindView(R.id.statusTextView)
    TextView statusTextView;
    @BindView(R.id.loginButton)
    Button loginButton;

    private Bus bus;
    private String baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        bus = ((App) getApplication()).getBus();
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
        CertificateManager certificateManager = new CertificateManager(baseUrl, bus);
    }

    @Subscribe
    public void onCertificateReady(CertyfikatReadyEvent event) {
        CertificateResponse.Certyfikat certificate = event.getCertificate();
        String requestSignature = event.getRequestSignature();

        PupilsListManager pupilsListManager = new PupilsListManager(bus, baseUrl, requestSignature, certificate.getCertyfikatKlucz());

        statusTextView.setText(String.format("OK\n\n%s", event.getCertificate().getUzytkownikLogin()));
    }

    @Subscribe
    public void onPupilsListReady(PupilsListReadyEvent event) {
        statusTextView.setText(statusTextView.getText() + "\n\nPupilsList - OK!");
    }
}
