package com.maciejprogramuje.facebook.logintest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://cufs.vulcan.net.pl/");
        //https://cufs.vulcan.net.pl
        builder.client(httpClient);
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        final VulcanApi vulcanApi = retrofit.create(VulcanApi.class);
        Call<User> call = vulcanApi.postLogin(", "");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.w("UWAGA", call.toString());


                if(response.isSuccessful()) {
                    Log.w("UWAGA", "=====================================================");
                    Log.w("UWAGA", "logowanie ok!");
                    Log.w("UWAGA", response.message());
                    Log.w("UWAGA", "=====================================================");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.w("UWAGA", t.getLocalizedMessage());
            }
        });


    }
}
