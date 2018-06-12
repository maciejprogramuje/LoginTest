package com.maciejprogramuje.facebook.logintest;

import android.app.Application;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ProgressBar;

import com.maciejprogramuje.facebook.logintest.uonet_api.common.ApiUonet;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.Oceny;
import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.Slowniki;
import com.squareup.otto.Bus;

import java.util.List;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class App extends Application {
    public static final String BASE_URL_KEY = "baseUrl";
    public static final String PFX_KEY = "pfx";
    public static final String CERTYFICATE_KEY_KEY = "certyficateKey";

    private String baseUrl;
    private String pfx;
    private String certyfikatKlucz;
    private Certyfikat.TokenCert tokenCert;
    private String jednostkaSprawozdawczaSymbol;
    private Integer idOkresKlasyfikacyjny;
    private Integer idUczen;
    private Slowniki.Slownik slownik;
    private Integer idOddzial;
    private List<Oceny.Ocena> oceny;

    private Bus bus;
    private SharedPreferences sharedPreferences;
    private ApiUonet apiUonet;
    private ProgressBar progressBar;

    @Override
    public void onCreate() {
        super.onCreate();

        bus = new Bus();

        sharedPreferences = getDefaultSharedPreferences(this);
        baseUrl = sharedPreferences.getString(BASE_URL_KEY, "");
        pfx = sharedPreferences.getString(PFX_KEY, "");
        certyfikatKlucz = sharedPreferences.getString(CERTYFICATE_KEY_KEY, "");
    }


    public Bus getBus() {
        return bus;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getPfx() {
        return pfx;
    }

    public void setPfx(String pfx) {
        this.pfx = pfx;
    }

    public ApiUonet getApiUonet() {
        return apiUonet;
    }

    public void setApiUonet(ApiUonet apiUonet) {
        this.apiUonet = apiUonet;
    }

    public String getCertyfikatKlucz() {
        return certyfikatKlucz;
    }

    public void setCertyfikatKlucz(String certyfikatKlucz) {
        this.certyfikatKlucz = certyfikatKlucz;
    }

    public Certyfikat.TokenCert getTokenCert() {
        return tokenCert;
    }

    public void setTokenCert(Certyfikat.TokenCert tokenCert) {
        this.tokenCert = tokenCert;
    }

    public String getJednostkaSprawozdawczaSymbol() {
        return jednostkaSprawozdawczaSymbol;
    }

    public void setJednostkaSprawozdawczaSymbol(String jednostkaSprawozdawczaSymbol) {
        this.jednostkaSprawozdawczaSymbol = jednostkaSprawozdawczaSymbol;
    }

    public Integer getIdOkresKlasyfikacyjny() {
        return idOkresKlasyfikacyjny;
    }

    public void setIdOkresKlasyfikacyjny(Integer idOkresKlasyfikacyjny) {
        this.idOkresKlasyfikacyjny = idOkresKlasyfikacyjny;
    }

    public Integer getIdUczen() {
        return idUczen;
    }

    public void setIdUczen(Integer idUczen) {
        this.idUczen = idUczen;
    }

    public Slowniki.Slownik getSlownik() {
        return slownik;
    }

    public void setSlownik(Slowniki.Slownik slownik) {
        this.slownik = slownik;
    }

    public Integer getIdOddzial() {
        return idOddzial;
    }

    public void setIdOddzial(Integer idOddzial) {
        this.idOddzial = idOddzial;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public List<Oceny.Ocena> getOceny() {
        return oceny;
    }

    public void setOceny(List<Oceny.Ocena> oceny) {
        this.oceny = oceny;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public void setProgressBarVisible() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void setProgressBarInvisible() {
        progressBar.setVisibility(View.GONE);
    }
}
