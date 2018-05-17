package com.maciejprogramuje.facebook.logintest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface VulcanApi {



    @FormUrlEncoded
    @POST("lublin/Account/LogOn?ReturnUrl=%2Flublin%2FFS%2FLS%3Fwa%3Dwsignin1.0%26wtrealm%3Dhttps%253a%252f%252fuonetplus.vulcan.net.pl%252flublin%252fLoginEndpoint.aspx%26wctx%3Dhttps%253a%252f%252fuonetplus.vulcan.net.pl%252flublin%252fLoginEndpoint.aspx")
    Call<User> postLogin(@Field("LoginName") String loginName, @Field("Password") String password);


    @GET("lublin/Start.mvc/Index")
    Call<User> getNextPage();

}
