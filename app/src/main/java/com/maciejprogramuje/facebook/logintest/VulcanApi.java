package com.maciejprogramuje.facebook.logintest;

import com.maciejprogramuje.facebook.logintest.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.models.CertyfikatRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface VulcanApi {

    @Headers({
            "RequestMobileType: RegisterDevice",
            "User-Agent: MobileUserAgent",
            "Content-Type: application/json"
    })
    @POST("/lublin/mobile-api/Uczen.v3.UczenStart/Certyfikat")
    Call<Certyfikat> postLogin(@Body CertyfikatRequest loginRequest);

}
