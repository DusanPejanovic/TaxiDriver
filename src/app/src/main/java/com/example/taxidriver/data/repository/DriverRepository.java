package com.example.taxidriver.data.repository;

import com.example.taxidriver.data.RetrofitClient;
import com.example.taxidriver.data.api.DriverApi;
import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.data.dto.PendingRideResponseDTO;
import com.example.taxidriver.data.dto.RideDTO;
import com.example.taxidriver.data.dto.VehicleDTO;

import java.io.IOException;

import retrofit2.Call;
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

    public void getDriverVehicle(Callback<VehicleDTO> callback, String id) {
        driverApi.getDriverVehicle(id).enqueue(callback);
    }


    public void putDriverActive() {
        driverApi.putDriverActive().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }


    public void putDriverUnactive() {
        driverApi.putDriverUnactive().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }


}

