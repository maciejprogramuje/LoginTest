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
import com.maciejprogramuje.facebook.logintest.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.models.CertyfikatRequest;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// -------------------------------------------------------------------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------- Jak znaleść właściwy baseUrl? -----------------------------------------------------------
// -------------------------------------------------------------------------------------------------------------------------------------------------------
// Spis baseUrl jest pod adresem:
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
// Itotne są pierwsze trzy znaki tokenu: np. dla Gimnazjum 16 w Lublinie (token zaczyna się od 3S1), właściwy baseUrl to https://lekcjaplus.vulcan.net.pl
// -------------------------------------------------------------------------------------------------------------------------------------------------------
// Nie jest tak, że każda szkoła ma swój baseUrl!
// -------------------------------------------------------------------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------------------------------------------------------------


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
        builder.baseUrl("https://lekcjaplus.vulcan.net.pl");
        builder.client(httpClient);
        retrofit = builder.build();

        CertyfikatRequest certyfikatRequest = new CertyfikatRequest("809129", "3S1LREL6");

        final VulcanApi vulcanApi = retrofit.create(VulcanApi.class);
        Call<Certyfikat> call = vulcanApi.postLogin(certyfikatRequest);
        call.enqueue(new Callback<Certyfikat>() {
            @Override
            public void onResponse(@NonNull Call<Certyfikat> call, @NonNull Response<Certyfikat> response) {
                if (response.isSuccessful()) {



                    Certyfikat.TokenCertificate certyfikat = response.body().getTokenCert();
                    statusTextView.setText(String.format("OK\n\n%s", certyfikat.getUzytkownikLogin()));
                } else {
                    statusTextView.setText("blad 1");
                }
            }

            @Override
            public void onFailure(Call<Certyfikat> call, Throwable t) {
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
