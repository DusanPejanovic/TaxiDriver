package com.example.taxidriver.data.api;

import com.example.taxidriver.data.dto.PassengerDTO;
import com.example.taxidriver.data.dto.RideDTO;
import com.example.taxidriver.data.dto.VehicleDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PassengerApi {

    @GET("api/passenger/{passenger-id}")
    Call<PassengerDTO> getPassengerDetails(@Path("passenger-id") String id);

    @PUT("api/passenger/{passenger-id}")
    Call<PassengerDTO> changePassengerDetails(@Path("passenger-id") String id,@Body PassengerDTO request);

//    @GET("/api/driver/{id}/vehicle")
//    Call<VehicleDTO> getDriverVehicle(@Path("id") String id);
}
