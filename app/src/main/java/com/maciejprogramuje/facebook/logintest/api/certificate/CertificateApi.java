package com.maciejprogramuje.facebook.logintest.api.certificate;

import com.maciejprogramuje.facebook.logintest.api.certificate.models.CertificateRequest;
import com.maciejprogramuje.facebook.logintest.api.certificate.models.CertificateResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import static com.maciejprogramuje.facebook.logintest.MainActivity.SYMBOL;

public interface CertificateApi {

    @POST("/" + SYMBOL + "/mobile-api/Uczen.v3.UczenStart/Certyfikat")
    Call<CertificateResponse> postCerificate(@Body CertificateRequest loginRequest, @HeaderMap Map<String, String> headesMap);

}
