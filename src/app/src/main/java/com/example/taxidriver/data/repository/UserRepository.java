package com.example.taxidriver.data.repository;

import com.example.taxidriver.data.UserApi;
import com.example.taxidriver.domain.model.User;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UserRepository {
    private static final String BASE_URL = "http://10.0.2.2:8080/";
    final private UserApi userApi;

    public UserRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userApi = retrofit.create(UserApi.class);
    }

    public void getUsers(Callback<List<User>> callback) {
        userApi.getUsers().enqueue(callback);
    }
}

