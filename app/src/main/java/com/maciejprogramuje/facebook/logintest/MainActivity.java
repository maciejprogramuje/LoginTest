package com.maciejprogramuje.facebook.logintest;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.maciejprogramuje.facebook.logintest.api.RetrofitGenerator;
import com.maciejprogramuje.facebook.logintest.api.login.LoginApi;
import com.maciejprogramuje.facebook.logintest.api.login.models.CertyfikatBody;
import com.maciejprogramuje.facebook.logintest.api.login.models.CertyfikatRequest;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
    public static final String PIN = "";
    public static final String TOKEN = "";
    public static final String SYMBOL = "lublin";
    public static final String BASE_URL = "";

    Button loginButton;
    TextView statusTextView;

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

                setBaseUrl();

                loginToVulcan();
            }
        });
    }

    private void setBaseUrl() {

    }

    private void loginToVulcan() {
        CertyfikatRequest certyfikatRequest = new CertyfikatRequest(PIN, TOKEN);

        RetrofitGenerator loginRetrofitGenerator = new RetrofitGenerator("https://lekcjaplus.vulcan.net.pl/");
        Retrofit loginRetrofit = loginRetrofitGenerator.get();
        final LoginApi loginApi = loginRetrofit.create(LoginApi.class);

        Call<CertyfikatBody> call = loginApi.postLogin(certyfikatRequest);
        call.enqueue(new Callback<CertyfikatBody>() {
            @Override
            public void onResponse(@NonNull Call<CertyfikatBody> call, @NonNull Response<CertyfikatBody> response) {
                if (response.isSuccessful()) {
                    CertyfikatBody certyfikatBody = response.body();
                    if (!certyfikatBody.getError()) {
                        CertyfikatBody.Certyfikat certyfikat = certyfikatBody.getTokenCert();
                        statusTextView.setText(String.format("OK\n\n%s", certyfikat.getUzytkownikLogin()));
                    } else {
                        statusTextView.setText("blad 1 - błędny lub przeterminowany PIN lub TOKEN");
                    }
                } else {
                    statusTextView.setText("blad 2 - błąd odpowiedzi");
                }
            }

            @Override
            public void onFailure(Call<CertyfikatBody> call, Throwable t) {
                String myErrorText;
                if (t instanceof IOException) {
                    statusTextView.setText("blad 3 - błąd połączenia ze stroną lub internetem");
                } else {
                    statusTextView.setText("blad 4 - błąd konwersji odpowiedzi");
                }
            }
        });
    }
}
