package com.maciejprogramuje.facebook.logintest.screens;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.maciejprogramuje.facebook.logintest.App;
import com.maciejprogramuje.facebook.logintest.QueryFor;
import com.maciejprogramuje.facebook.logintest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class F2_login extends Fragment {
    @BindView(R.id.pinEditText)
    EditText pinEditText;
    @BindView(R.id.symbolEditText)
    EditText symbolEditText;
    @BindView(R.id.tokenEditText)
    EditText tokenEditText;
    Unbinder unbinder;

    public F2_login() {

    }

    public static F2_login newInstance() {
        F2_login fragment = new F2_login();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.loginButton)
    public void onLoginButtonClicked() {
        String pin = pinEditText.getText().toString();
        String symbol = symbolEditText.getText().toString();
        String token = tokenEditText.getText().toString();

        App app = (App) getActivity().getApplication();
        app.setProgressBarVisible();

        QueryFor.baseUrl(app, pin, symbol, token);
    }
}
