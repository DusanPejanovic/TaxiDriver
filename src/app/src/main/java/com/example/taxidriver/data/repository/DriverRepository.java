package com.example.taxidriver.data.repository;

import com.example.taxidriver.data.RetrofitClient;
import com.example.taxidriver.data.api.DriverApi;
import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.data.dto.PendingRideResponseDTO;
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

    public void isTherePendingRide(Callback<RideDTO> callback, String id) {
        driverApi.isTherePendingRide(id).enqueue(callback);
    }

}

