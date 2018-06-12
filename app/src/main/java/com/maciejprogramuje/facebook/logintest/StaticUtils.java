package com.maciejprogramuje.facebook.logintest;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class StaticUtils {
    public static void changeFragment(Context context, Fragment newFragment) {
        FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
