package com.maciejprogramuje.facebook.logintest;

import com.maciejprogramuje.facebook.logintest.uonet_api.o01_base_url.BaseUrlManager;
import com.maciejprogramuje.facebook.logintest.uonet_api.o02_certyfikat.CertyfikatManager;
import com.maciejprogramuje.facebook.logintest.uonet_api.o03_uczniowie.UczniowieManager;
import com.maciejprogramuje.facebook.logintest.uonet_api.o04_log_app_start.LogAppStartManager;
import com.maciejprogramuje.facebook.logintest.uonet_api.o05_slowniki.SlownikiManager;
import com.maciejprogramuje.facebook.logintest.uonet_api.q_oceny.OcenyManager;
import com.maciejprogramuje.facebook.logintest.uonet_api.q_plan_lekcji.PlanLekcjiZeZmianamiManager;
import com.maciejprogramuje.facebook.logintest.uonet_api.q_srednie_prognozowane.OcenyPodsumowanieManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class QueryFor {
    public static void planLekcjiZeZmianami(App app) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String dataPoczatkowaString = "2018-06-11";
        String dataKoncowaString = "2018-06-15";

        try {
            Date dataPoczatkowa = formatter.parse(dataPoczatkowaString);
            Date dataKoncowa = formatter.parse(dataKoncowaString);
            PlanLekcjiZeZmianamiManager planLekcjiZeZmianamiManager = new PlanLekcjiZeZmianamiManager(app, dataPoczatkowa, dataKoncowa);
            planLekcjiZeZmianamiManager.generate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void ocenyPodsumowanie(App app) {
        OcenyPodsumowanieManager ocenyPodsumowanieManager = new OcenyPodsumowanieManager(app);
        ocenyPodsumowanieManager.generate();
    }

    public static void oceny(App app) {
        OcenyManager ocenyManager = new OcenyManager(app);
        ocenyManager.generate();
    }

    public static void slowniki(App app) {
        SlownikiManager slownikiManager = new SlownikiManager(app);
        slownikiManager.generate();
    }

    public static void logAppStart(App app) {
        LogAppStartManager logAppStartManager = new LogAppStartManager(app);
        logAppStartManager.generate();
    }

    public static void uczniowie(App app) {
        UczniowieManager uczniowieManager = new UczniowieManager(app);
        uczniowieManager.generate();
    }

    public static void certyfikat(App app, String pin, String token) {
        CertyfikatManager certyfikatManager = new CertyfikatManager(app);
        certyfikatManager.generate(pin, token);
    }

    public static void baseUrl(App app, String token) {
        BaseUrlManager baseUrlManager = new BaseUrlManager(token, app);
        baseUrlManager.generateBaseUrl();
    }
}
