package com.maciejprogramuje.facebook.logintest.api.base_url;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseUrlApi {

    @GET("/UonetPlusMobile/RoutingRules.txt")
    Call<ResponseBody> getBaseUrl();

}
