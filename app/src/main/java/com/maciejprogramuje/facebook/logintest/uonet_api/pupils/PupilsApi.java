package com.maciejprogramuje.facebook.logintest.uonet_api.pupils;

import com.maciejprogramuje.facebook.logintest.uonet_api.models.Uczniowie;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.UczniowieRequest;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface PupilsApi {

    @POST("mobile-api/Uczen.v3.UczenStart/ListaUczniow")
    Call<Uczniowie> postPupils(@Body UczniowieRequest uczniowieReq, @HeaderMap Map<String, String> headesMap);

}
