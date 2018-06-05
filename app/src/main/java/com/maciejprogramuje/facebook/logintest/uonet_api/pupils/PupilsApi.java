package com.maciejprogramuje.facebook.logintest.uonet_api.pupils;

import com.maciejprogramuje.facebook.logintest.uonet_api.models.UczniowieRequest3;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import static com.maciejprogramuje.facebook.logintest.MainActivity.SYMBOL;

public interface PupilsApi {

    @POST("/" + SYMBOL + "/mobile-api/Uczen.v3.UczenStart/ListaUczniow")
    Call<Void> postPupils(@Body UczniowieRequest3 uczniowieRequest3, @HeaderMap Map<String, String> headesMap);

}
