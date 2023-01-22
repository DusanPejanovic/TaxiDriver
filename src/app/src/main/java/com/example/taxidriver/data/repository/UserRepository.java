package com.example.taxidriver.data.repository;

import com.example.taxidriver.data.RetrofitClient;
import com.example.taxidriver.data.api.UserApi;
import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.domain.model.User;

import java.util.List;

import retrofit2.Callback;


public class UserRepository {
    final private UserApi userApi;

    public UserRepository() {
        userApi = RetrofitClient.getInstance().create(UserApi.class);
    }

    public void getUsers(Callback<PaginatedResponse<User>> callback) {
        userApi.getUsers().enqueue(callback);
    }
}

