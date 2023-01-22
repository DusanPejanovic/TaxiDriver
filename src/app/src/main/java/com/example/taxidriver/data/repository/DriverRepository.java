package com.example.taxidriver.data.repository;

import com.example.taxidriver.data.RetrofitClient;
import com.example.taxidriver.data.api.DriverApi;
import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.data.dto.RideDTO;

import java.io.IOException;

import retrofit2.Callback;
import retrofit2.Response;


public class DriverRepository {
    final private DriverApi driverApi;

    public DriverRepository() {
        driverApi = RetrofitClient.getInstance().create(DriverApi.class);
    }

    public void getRideHistory(Callback<PaginatedResponse<RideDTO>> callback, String id) {
        driverApi.getRideHistory(id).enqueue(callback);
    }

    public Response<PaginatedResponse<RideDTO>> getRideHistory2(String id) throws IOException {
        return  driverApi.getRideHistory(id).execute();
    }
}

