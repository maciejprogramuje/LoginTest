package com.maciejprogramuje.facebook.logintest.uonet_api.common;

import android.util.Log;

import java.io.IOException;

import retrofit2.Response;

public class ApiErrors {
    public static void show(Response response) {
        try {
            Log.w("UWAGA", "blad 2 - błąd odpowiedzi\n" + response.errorBody().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void show(Throwable t) {
        if (t instanceof IOException) {
            Log.w("UWAGA", "blad 3 - błąd połączenia ze stroną (internetem) lub brakuje jakiegoś pola w klasie response");
            t.printStackTrace();
        } else {
            Log.w("UWAGA", "blad 4 - błąd konwersji odpowiedzi");
        }
    }
}
