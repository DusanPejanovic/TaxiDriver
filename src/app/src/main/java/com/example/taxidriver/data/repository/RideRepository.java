package com.example.taxidriver.data.repository;

import android.widget.Toast;

import com.example.taxidriver.TaxiDriver;
import com.example.taxidriver.data.RetrofitClient;
import com.example.taxidriver.data.api.DriverApi;
import com.example.taxidriver.data.api.RideApi;
import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.data.dto.RideDTO;
import com.example.taxidriver.data.dto.RideRequestDTO;
import com.example.taxidriver.domain.model.Ride;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RideRepository {
    final private RideApi rideApi;

    public RideRepository() {
        rideApi = RetrofitClient.getInstance().create(RideApi.class);
    }

    public void submitRideRequest(Callback<RideDTO> callback, RideRequestDTO rideRequest) {
        rideApi.submitRequestForRide(rideRequest).enqueue(callback);
    }

}
