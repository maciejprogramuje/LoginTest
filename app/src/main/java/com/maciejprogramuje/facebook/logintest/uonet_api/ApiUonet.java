package com.maciejprogramuje.facebook.logintest.uonet_api;


import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.RequestAbst;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Uczniowie;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;


public interface ApiUonet {

    //"UonetPlusMobile/RoutingRules.txt"
    @GET()
    Call<ResponseBody> getBaseUrl(@Url String apiUrl);

    //"mobile-api/Uczen.v3.UczenStart/Certyfikat"
    @POST()
    Call<Certyfikat> postCerificate(@Url String apiUrl, @Body RequestAbst certyfikatRequest, @HeaderMap Map<String, String> headesMap);

    //"mobile-api/Uczen.v3.UczenStart/ListaUczniow"
    @POST()
    Call<Uczniowie> postPupils(@Url String apiUrl, @Body RequestAbst uczniowieReq, @HeaderMap Map<String, String> headesMap);

    //"${JednostkaSprawozdawczaSymbol}/mobile-api/Uczen.v3.Uczen/LogAppStart"
    @POST()
    Call<Uczniowie> postLogAppStart(@Url String apiUrl, @Body RequestAbst uczniowieReq, @HeaderMap Map<String, String> headesMap);

}
