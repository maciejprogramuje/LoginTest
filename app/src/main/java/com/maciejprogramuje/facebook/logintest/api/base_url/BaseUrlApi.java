package com.maciejprogramuje.facebook.logintest.api.base_url;

import com.maciejprogramuje.facebook.logintest.api.login.models.CertyfikatBody;
import com.maciejprogramuje.facebook.logintest.api.login.models.CertyfikatRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface BaseUrlApi {

    @GET("/mobile-api/Uczen.v3.UczenStart/Certyfikat")
    Call<CertyfikatBody> postLogin(@Body CertyfikatRequest loginRequest);

}
