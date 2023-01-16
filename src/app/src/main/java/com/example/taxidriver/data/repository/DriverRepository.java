package com.example.taxidriver.data.repository;

import com.example.taxidriver.data.RetrofitClient;
import com.example.taxidriver.data.api.DriverApi;
import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.domain.model.Ride;

import java.util.List;

import retrofit2.Callback;


public class DriverRepository {
    final private DriverApi driverApi;

    public DriverRepository() {
        driverApi = RetrofitClient.getInstance().create(DriverApi.class);
    }

    public void getRideHistory(Callback<PaginatedResponse<Ride>> callback, String id) {
        driverApi.getRideHistory(id).enqueue(callback);
    }
}

