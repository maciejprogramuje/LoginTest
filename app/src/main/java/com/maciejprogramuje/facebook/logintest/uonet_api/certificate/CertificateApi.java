package com.maciejprogramuje.facebook.logintest.uonet_api.certificate;


import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.CertyfikatRequest;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;


public interface CertificateApi {

    @POST("mobile-api/Uczen.v3.UczenStart/Certyfikat")
    Call<Certyfikat> postCerificate(@Body CertyfikatRequest certyfikatRequest, @HeaderMap Map<String, String> headesMap);

}
