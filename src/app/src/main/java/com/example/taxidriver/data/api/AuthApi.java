package com.example.taxidriver.data.api;

import com.example.taxidriver.domain.model.User;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AuthApi {
    @POST("auth/login")
    Call<JsonObject> login(@Body JsonObject jsonObject);

    @POST("auth/signup")
    Call<Void> signup(@Body User user);

    @GET("/user")
    Call<JsonObject> getUser(@Header("Authorization") String access_token);
}
