package com.maciejprogramuje.facebook.logintest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface VulcanApi {

    @Headers({
            "RequestMobileType: RegisterDevice",
            "User-Agent: MobileUserAgent"
            //todo json
    })
    @POST("/lublin/mobile-api/Uczen.v3.UczenStart/Certyfikat")
    Call<Void> postLogin(@Body LoginRequest loginRequest);

}
