package com.maciejprogramuje.facebook.logintest;

import android.content.SharedPreferences;
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

import static com.maciejprogramuje.facebook.logintest.App.BASE_URL_KEY;
import static com.maciejprogramuje.facebook.logintest.App.CERTIFICATE_KEY;
import static com.maciejprogramuje.facebook.logintest.App.REQUEST_SIGNATURE_KEY;

public class MainActivity extends AppCompatActivity {
    private final String token = "3S1TTVH3";
    public static final String SYMBOL = "lublin";
    private final String pin = "289775";

    @BindView(R.id.statusTextView)
    TextView statusTextView;
    @BindView(R.id.loginButton)
    Button loginButton;

    private Bus bus;
    private App app;
    private CertificateResponse.Certyfikat certificate;
    private SharedPreferences.Editor sharedPreferencesEditor;
    private String mBaseUrl;
    private String mCertificateKey;
    private String mRequestSignature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        app = (App) getApplication();
        bus = app.getBus();
        sharedPreferencesEditor = app.getSharedPreferences().edit();
        mBaseUrl = app.getBaseUrl();
        mCertificateKey = app.getCertificateKey();
        mRequestSignature = app.getRequestSignature();

        if(mBaseUrl.isEmpty() || mCertificateKey.isEmpty() || mRequestSignature.isEmpty()) {
            loginButton.setEnabled(true);
        } else {
            loginButton.setEnabled(false);
            postForPupilsList();
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
        BaseUrlManager baseUrlManager = new BaseUrlManager(token, bus);
        baseUrlManager.postBaseUrlEvent();
    }

    @Subscribe
    public void onBaseUrlReady(BaseUrlReadyEvent event) {
        mBaseUrl = event.getBaseUrl();
        sharedPreferencesEditor.putString(BASE_URL_KEY, mBaseUrl).apply();

        CertificateManager certificateManager = new CertificateManager(mBaseUrl, bus);
        certificateManager.generateCerificate(pin, token);
    }

    @Subscribe
    public void onCertificateReady(CertyfikatReadyEvent event) {
        certificate = event.getCertificate();
        mCertificateKey = certificate.getCertyfikatKlucz();
        mRequestSignature = event.getRequestSignature();

        sharedPreferencesEditor.putString(CERTIFICATE_KEY, mCertificateKey)
                .putString(REQUEST_SIGNATURE_KEY, mRequestSignature)
                .apply();

        statusTextView.setText(String.format("OK\n\n%s", certificate.getUzytkownikLogin()));

        postForPupilsList();
    }

    private void postForPupilsList() {
        PupilsListManager pupilsListManager = new PupilsListManager(bus, mBaseUrl, mRequestSignature, mCertificateKey);
    }

    @Subscribe
    public void onPupilsListReady(PupilsListReadyEvent event) {
        statusTextView.setText(statusTextView.getText() + "\n\nPupilsList - OK!");
    }
}
