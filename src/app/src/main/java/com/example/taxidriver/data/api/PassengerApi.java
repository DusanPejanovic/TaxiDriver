package com.example.taxidriver.data.api;

import com.example.taxidriver.data.dto.PassengerDTO;
import com.example.taxidriver.data.dto.RideDTO;
import com.example.taxidriver.data.dto.VehicleDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PassengerApi {

    @GET("api/driver/pending-ride/{driver-id}")
    Call<PassengerDTO> getPassengerDetails(@Path("passenger-id") String id);

//    @GET("/api/driver/{id}/vehicle")
//    Call<VehicleDTO> getDriverVehicle(@Path("id") String id);
}
