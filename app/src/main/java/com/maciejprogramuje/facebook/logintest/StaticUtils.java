package com.maciejprogramuje.facebook.logintest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class StaticUtils {
    public static void changeFragment(Context context, Fragment newFragment) {
        FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static void adRequest(AdView adView) {
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public static void hideKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
    }

    public static void noInternetConnectionReaction(Context context) {
        Toast.makeText(context, context.getResources().getString(R.string.turn_on_internet), Toast.LENGTH_LONG).show();
    }

    public static boolean isInternetConnection(Context context) {
        ConnectivityManager con_manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert con_manager != null;
        return con_manager.getActiveNetworkInfo() != null;
    }
}
