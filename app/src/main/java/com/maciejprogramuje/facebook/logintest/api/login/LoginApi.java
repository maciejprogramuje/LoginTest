package com.maciejprogramuje.facebook.logintest.api.login;

import com.maciejprogramuje.facebook.logintest.api.login.models.CertyfikatBody;
import com.maciejprogramuje.facebook.logintest.api.login.models.CertyfikatRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static com.maciejprogramuje.facebook.logintest.MainActivity.SYMBOL;

public interface LoginApi {

    @Headers({
            "RequestMobileType: RegisterDevice",
            "User-Agent: MobileUserAgent",
            "Content-Type: application/json"
    })
    @POST("/" + SYMBOL + "/mobile-api/Uczen.v3.UczenStart/Certyfikat")
    Call<CertyfikatBody> postLogin(@Body CertyfikatRequest loginRequest);

}
