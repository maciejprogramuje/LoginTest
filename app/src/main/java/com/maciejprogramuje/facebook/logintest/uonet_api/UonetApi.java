package com.maciejprogramuje.facebook.logintest.uonet_api;


import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.CertyfikatRequest;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Uczniowie;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.UczniowieRequest;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;


public interface UonetApi {

    @GET("UonetPlusMobile/RoutingRules.txt")
    Call<ResponseBody> getBaseUrl();

    @POST("mobile-api/Uczen.v3.UczenStart/Certyfikat")
    Call<Certyfikat> postCerificate(@Body CertyfikatRequest certyfikatRequest, @HeaderMap Map<String, String> headesMap);

    @POST("mobile-api/Uczen.v3.UczenStart/ListaUczniow")
    Call<Uczniowie> postPupils(@Body UczniowieRequest uczniowieReq, @HeaderMap Map<String, String> headesMap);

}
