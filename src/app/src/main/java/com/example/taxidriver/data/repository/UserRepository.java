package com.example.taxidriver.data.repository;

import com.example.taxidriver.data.RetrofitClient;
import com.example.taxidriver.data.UserApi;
import com.example.taxidriver.domain.model.User;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UserRepository {
    final private UserApi userApi;

    public UserRepository() {
        userApi = RetrofitClient.getInstance().create(UserApi.class);
    }

    public void getUsers(Callback<List<User>> callback) {
        userApi.getUsers().enqueue(callback);
    }
}

