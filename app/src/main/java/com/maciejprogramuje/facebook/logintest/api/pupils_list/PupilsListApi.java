package com.maciejprogramuje.facebook.logintest.api.pupils_list;

import com.maciejprogramuje.facebook.logintest.api.pupils_list.models.PupilsListRequest;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import static com.maciejprogramuje.facebook.logintest.MainActivity.SYMBOL;


public interface PupilsListApi {

    @POST("/" + SYMBOL + "/mobile-api/Uczen.v3.UczenStart/ListaUczniow")
    Call<ResponseBody> postPupilsList(@Body PupilsListRequest pupilsListRequest, @HeaderMap Map<String, String> headesMap);

}
