package com.maciejprogramuje.facebook.logintest.uonet_api.pupils;

import com.maciejprogramuje.facebook.logintest.uonet_api.models.Uczniowie;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import static com.maciejprogramuje.facebook.logintest.MainActivity.SYMBOL;

public interface PupilsApi {

    @POST("/" + SYMBOL + "/mobile-api/Uczen.v3.UczenStart/ListaUczniow")
    Call<Uczniowie> postPupils(@Body PupilsRequest pupilsRequest, @HeaderMap Map<String, String> headesMap);

}
