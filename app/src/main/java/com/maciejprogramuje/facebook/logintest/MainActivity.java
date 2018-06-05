package com.maciejprogramuje.facebook.logintest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.maciejprogramuje.facebook.logintest.uonet_api.UONETClient;
import com.maciejprogramuje.facebook.logintest.uonet_api.base_url.BaseUrlManager;
import com.maciejprogramuje.facebook.logintest.uonet_api.base_url.BaseUrlReadyEvent;
import com.maciejprogramuje.facebook.logintest.uonet_api.certificate.CertificateManager;
import com.maciejprogramuje.facebook.logintest.uonet_api.certificate.CertificateReadyEvent;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.maciejprogramuje.facebook.logintest.App.BASE_URL_KEY;
import static com.maciejprogramuje.facebook.logintest.App.CERTYFICATE_KEY_KEY;
import static com.maciejprogramuje.facebook.logintest.App.PFX_KEY;

public class MainActivity extends AppCompatActivity {
    public static final String TOKEN = "3S1HVJG2";
    public static final String SYMBOL = "lublin";
    public static final String PIN = "214753";

    @BindView(R.id.statusTextView)
    TextView statusTextView;
    @BindView(R.id.loginButton)
    Button loginButton;

    private Bus bus;
    private App app;
    private SharedPreferences.Editor sharedPreferencesEditor;
    private String mBaseUrl;
    private String mPfx;
    private String mCertficateKey;
    private UONETClient client;
    private Certyfikat.TokenCert tokenCert;

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
        mPfx = app.getPfx();
        mCertficateKey = app.getCertificateKey();

        /*mCertficateKey = ("83468642E73D92AB9C172543346302D7C7A095DB");
        mPfx = ("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");
        mBaseUrl = ("https://lekcjaplus.vulcan.net.pl/lublin");*/

        if (mBaseUrl.isEmpty() || mPfx.isEmpty() || mCertficateKey.isEmpty()) {
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
        BaseUrlManager baseUrlManager = new BaseUrlManager(TOKEN, app);
        baseUrlManager.generateBaseUrl();
    }

    @Subscribe
    public void onBaseUrlReady(BaseUrlReadyEvent event) {
        mBaseUrl = event.getBaseUrl();

        Log.w("UWAGA", "onBaseUrlReady -> " + mBaseUrl);

        sharedPreferencesEditor.putString(BASE_URL_KEY, mBaseUrl).apply();

        CertificateManager certificateManager = new CertificateManager(mBaseUrl, bus);
        certificateManager.generateCerificate(PIN, TOKEN);
    }

    @Subscribe
    public void onCertificateReady(CertificateReadyEvent event) {
        //client = new UONETClient(event.getCert());

        mPfx = event.getCertyfikatPfx();
        mCertficateKey = event.getCertyfikatKlucz();

        Log.w("UWAGA", "mPfx -> " + mPfx + ", mCertficateKey -> " + mCertficateKey);

        sharedPreferencesEditor.putString(PFX_KEY, mPfx)
                .putString(CERTYFICATE_KEY_KEY, mCertficateKey)
                .apply();

        postForPupilsList();
    }

    private void postForPupilsList() {
        //PupilsListManager pupilsListManager = new PupilsListManager(bus, mBaseUrl, mPfx, mCertficateKey);

        Log.w("UWAGA", "Dane logowania: mPfx -> " + mPfx + ", mCertficateKey -> " + mCertficateKey);

        /*if (client == null) {
            Certyfikat.TokenCertificate cert = new Certyfikat.TokenCertificate();
            cert.setCertyfikatKlucz(mCertficateKey);
            cert.setCertyfikatPfx(mPfx);
            cert.setAdresBazowyRestApi(mBaseUrl);

            client = new UONETClient(cert);
        }

        try {
            Uczniowie uczniowie = client.doRequest(new UczniowieRequest());
        } catch (UONETException e) {
            e.printStackTrace();
        }*/

    }
/*
    @Subscribe
    public void onPupilsListReady(PupilsListReadyEvent event) {
        statusTextView.setText(statusTextView.getText() + "\n\nPupilsList - OK!");
    }*/
}
