package com.maciejprogramuje.facebook.logintest.uonet_api.common;


import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.CertyfikatRequest;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.LogAppStartRequest;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Oceny;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.OcenyPodsumowanie;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.OcenyPodsumowanieRequest;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.OcenyRequest;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Slowniki;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.SlownikiRequest;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Uczniowie;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.UczniowieRequest;

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
    Call<Certyfikat> postCerificate(@Url String apiUrl, @Body CertyfikatRequest request, @HeaderMap Map<String, String> headesMap);

    //"mobile-api/Uczen.v3.UczenStart/ListaUczniow"
    @POST()
    Call<Uczniowie> postPupils(@Url String apiUrl, @Body UczniowieRequest request, @HeaderMap Map<String, String> headesMap);

    //"${JednostkaSprawozdawczaSymbol}/mobile-api/Uczen.v3.Uczen/LogAppStart"
    @POST()
    Call<ResponseBody> postLogAppStart(@Url String apiUrl, @Body LogAppStartRequest request, @HeaderMap Map<String, String> headesMap);

    //${symbol jednostki sprawozdawczej}/mobile-api/Uczen.v3.Uczen/Slowniki
    @POST()
    Call<Slowniki> postSlowniki(@Url String apiUrl, @Body SlownikiRequest request, @HeaderMap Map<String, String> headesMap);

    //${symbol jednostki sprawozdawczej}/mobile-api/Uczen.v3.Uczen/Oceny
    @POST()
    Call<Oceny> postOceny(@Url String apiUrl, @Body OcenyRequest request, @HeaderMap Map<String, String> headesMap);

    @POST()
    Call<OcenyPodsumowanie> postOcenyPodsumowanie(@Url String apiUrl, @Body OcenyPodsumowanieRequest request, @HeaderMap Map<String, String> headesMap);
}
