package com.example.taxidriver.data;

import com.example.taxidriver.domain.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {
    @GET("api/user")
    Call<List<User>> getUsers();
}
