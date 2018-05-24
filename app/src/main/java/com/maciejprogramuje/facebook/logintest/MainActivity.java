package com.maciejprogramuje.facebook.logintest;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.maciejprogramuje.facebook.logintest.api.base_url.BaseUrlManager;
import com.maciejprogramuje.facebook.logintest.api.base_url.BaseUrlReadyEvent;
import com.maciejprogramuje.facebook.logintest.api.login.CertyfikatReadyEvent;
import com.maciejprogramuje.facebook.logintest.api.login.LoginManager;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// -------------------------------------------------------------------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------- Jak znaleść właściwy BASE_URL? -----------------------------------------------------------
// -------------------------------------------------------------------------------------------------------------------------------------------------------
// Spis BASE_URL jest pod adresem:
// http://komponenty.vulcan.net.pl/UonetPlusMobile/RoutingRules.txt
//
// 3S1,https://lekcjaplus.vulcan.net.pl
// TA1,https://uonetplus-komunikacja.umt.tarnow.pl
// OP1,https://uonetplus-komunikacja.eszkola.opolskie.pl
// RZ1,https://uonetplus-komunikacja.resman.pl
// GD1,https://uonetplus-komunikacja.edu.gdansk.pl
// P03,https://efeb-komunikacja-pro-efebmobile.pro.vulcan.pl
// P01,http://efeb-komunikacja.pro-hudson.win.vulcan.pl
// P02,http://efeb-komunikacja.pro-hudsonrc.win.vulcan.pl
// P90,http://efeb-komunikacja-pro-mwujakowska.neo.win.vulcan.pl
//
// -------------------------------------------------------------------------------------------------------------------------------------------------------
// Itotne są pierwsze trzy znaki tokenu: np. dla Gimnazjum 16 w Lublinie (TOKEN zaczyna się od 3S1), właściwy BASE_URL to https://lekcjaplus.vulcan.net.pl
// -------------------------------------------------------------------------------------------------------------------------------------------------------
// Nie jest tak, że każda szkoła ma swój BASE_URL!
// -------------------------------------------------------------------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------------------------------------------------------------


public class MainActivity extends AppCompatActivity {
    public static final String TOKEN = "3S1CMMM0";
    public static final String SYMBOL = "lublin";
    public static final String PIN = "092666";

    @BindView(R.id.statusTextView)
    TextView statusTextView;
    @BindView(R.id.loginButton)
    Button loginButton;

    private Bus bus;

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
        loginToVulcan(event.getBaseUrl());
    }

    private void loginToVulcan(String baseUrl) {
        LoginManager loginManager = new LoginManager(baseUrl, bus);
        loginManager.postCertificateEvent();
    }

    @Subscribe
    public void onCertificateReady(CertyfikatReadyEvent event) {
        statusTextView.setText(String.format("OK\n\n%s", event.getCertyfikat().getUzytkownikLogin()));
    }
}
