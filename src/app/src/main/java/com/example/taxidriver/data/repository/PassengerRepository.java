package com.example.taxidriver.data.repository;

import com.example.taxidriver.data.RetrofitClient;
import com.example.taxidriver.data.api.DriverApi;
import com.example.taxidriver.data.api.PassengerApi;
import com.example.taxidriver.data.dto.PassengerDTO;
import com.example.taxidriver.data.dto.VehicleDTO;

import retrofit2.Callback;

public class PassengerRepository {
    final private PassengerApi passengerApi;

    public PassengerRepository() {
        passengerApi = RetrofitClient.getInstance().create(PassengerApi.class);
    }

    public void getDriverVehicle(Callback<PassengerDTO> callback, String id) {
        passengerApi.getPassengerDetails(id).enqueue(callback);
    }
}
