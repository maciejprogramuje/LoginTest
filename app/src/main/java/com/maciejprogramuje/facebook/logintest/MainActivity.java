package com.maciejprogramuje.facebook.logintest;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button loginButton;
    TextView statusTextView;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        loginButton = findViewById(R.id.loginButton);
        statusTextView = findViewById(R.id.statusTextView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("UWAGA", "login clicked!");
                loginToVulcan();
            }
        });
    }

    private void loginToVulcan() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build();
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create(gson));
        builder.baseUrl("https://uonetplus.vulcan.net.pl");
        builder.client(httpClient);
        retrofit = builder.build();

        LoginRequest loginRequest = new LoginRequest("851049", "3S1H8749");

        final VulcanApi vulcanApi = retrofit.create(VulcanApi.class);
        Call<Void> call = vulcanApi.postLogin(loginRequest);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (response.isSuccessful()) {
                    statusTextView.setText("OK");
                } else {
                    statusTextView.setText("blad 1");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                String myErrorText;
                if (t instanceof IOException) {
                    myErrorText = "this is an actual network failure :( inform the user and possibly retry";
                } else {
                    myErrorText = "conversion issue! big problems :(";
                }

                statusTextView.setText("blad 2\n" + t.getLocalizedMessage() + "\n\n" + myErrorText);
            }
        });
    }
}
