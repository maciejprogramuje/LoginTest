package com.maciejprogramuje.facebook.logintest;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.maciejprogramuje.facebook.logintest.screens.frag1_login.Intro;
import com.maciejprogramuje.facebook.logintest.screens.frag2_login.Login;
import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiGenerator;
import com.maciejprogramuje.facebook.logintest.uonet_api.log1_base_url.BaseUrlReadyEvent;
import com.maciejprogramuje.facebook.logintest.uonet_api.log2_certyfikat.CertyfikatReadyEvent;
import com.maciejprogramuje.facebook.logintest.uonet_api.log3_uczniowie.UczniowieReadyEvent;
import com.maciejprogramuje.facebook.logintest.uonet_api.log4_log_app_start.LogAppStartReadyEvent;
import com.maciejprogramuje.facebook.logintest.uonet_api.log5_slowniki.SlownikiReadyEvent;
import com.maciejprogramuje.facebook.logintest.uonet_api.que_oceny.OcenyReadyEvent;
import com.maciejprogramuje.facebook.logintest.uonet_api.que_plan_lekcji.PlanLekcjiZeZmianamiReadyEvent;
import com.maciejprogramuje.facebook.logintest.uonet_api.que_srednie_prognozowane.OcenyPodsumowanieEvent;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.Oceny;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.Slowniki;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.maciejprogramuje.facebook.logintest.App.BASE_URL_KEY;
import static com.maciejprogramuje.facebook.logintest.App.CERTYFICATE_KEY_KEY;
import static com.maciejprogramuje.facebook.logintest.App.PFX_KEY;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private Bus bus;
    private App app;
    private SharedPreferences.Editor sharedPreferencesEditor;

    private String mBaseUrl;
    private String mPfx;
    private String mCertyfikatKlucz;
    private Certyfikat.TokenCert mTokenCert;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        StaticUtils.initializeAd(this);

        app = (App) getApplication();
        app.setProgressBar(progressBar);
        bus = app.getBus();
        sharedPreferencesEditor = app.getSharedPreferences().edit();
        mBaseUrl = app.getBaseUrl();
        mPfx = app.getPfx();
        mCertyfikatKlucz = app.getCertyfikatKlucz();


        progressBar.setVisibility(View.VISIBLE);
        StaticUtils.changeFragment(this, Intro.newInstance());

        if (mBaseUrl.isEmpty() || mPfx.isEmpty() || mCertyfikatKlucz.isEmpty()) {
            progressBar.setVisibility(View.GONE);
            StaticUtils.changeFragment(this, Login.newInstance());
        } else {
            ApiGenerator.generate(app, mBaseUrl);
            postUczniowie();
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

    @Subscribe
    public void onBaseUrlReady(BaseUrlReadyEvent event) {
        mBaseUrl = event.getBaseUrl();
        sharedPreferencesEditor.putString(BASE_URL_KEY, mBaseUrl).apply();

        ApiGenerator.generate(app, mBaseUrl);
        QueryFor.certyfikat(app, event.getPin(), event.getToken());
    }

    @Subscribe
    public void onCertificateReady(CertyfikatReadyEvent event) {

        mCertyfikatKlucz = event.getCertyfikatKlucz();
        mPfx = event.getCertyfikatPfx();

        app.setPfx(mPfx);
        app.setCertyfikatKlucz(mCertyfikatKlucz);
        sharedPreferencesEditor.putString(PFX_KEY, mPfx)
                .putString(CERTYFICATE_KEY_KEY, mCertyfikatKlucz)
                .apply();

        postUczniowie();
    }

    private void postUczniowie() {
        mTokenCert = new Certyfikat.TokenCert();
        mTokenCert.setCertyfikatKlucz(mCertyfikatKlucz);
        mTokenCert.setCertyfikatPfx(mPfx);
        mTokenCert.setAdresBazowyRestApi(mBaseUrl);

        app.setTokenCert(mTokenCert);

        QueryFor.uczniowie(app);
    }

    @Subscribe
    public void onUczniowieReady(UczniowieReadyEvent event) {
        QueryFor.logAppStart(app);
    }

    @Subscribe
    public void onLogAppStartReady(LogAppStartReadyEvent event) {
        QueryFor.slowniki(app);
    }

    @Subscribe
    public void onSlownikiReady(SlownikiReadyEvent event) {
        QueryFor.oceny(app);
    }

    @Subscribe
    public void onOcenyReady(OcenyReadyEvent event) {
        QueryFor.ocenyPodsumowanie(app);
    }

    @Subscribe
    public void onOcenyPodsumowanieReady(OcenyPodsumowanieEvent event) {
        QueryFor.planLekcjiZeZmianami(app);
    }

    @Subscribe
    public void onPlanLekcjiReady(PlanLekcjiZeZmianamiReadyEvent event) {

        progressBar.setVisibility(View.GONE);

        List<Slowniki.Przedmiot> przedmioty = app.getSlownik().getPrzedmioty();
        for (Slowniki.Przedmiot przedmiot : przedmioty) {
            Log.w("UWAGA", przedmiot.getId() + ": " + przedmiot.getNazwa());
        }


        List<Oceny.Ocena> oceny = app.getOceny();
        for (Oceny.Ocena ocena : oceny) {
            if (ocena.getIdPrzedmiot() == 12396) {
                Log.w("UWAGA", "----------------> " + ocena.toString() + ", kat: " + app.getSlownik().getKategoriaOceny(ocena.getIdKategoria()).getNazwa());
            }
        }
    }
}
