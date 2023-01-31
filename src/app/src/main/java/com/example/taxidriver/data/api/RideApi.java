package com.example.taxidriver.data.api;

import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.data.dto.RideDTO;
import com.example.taxidriver.data.dto.RideRequestDTO;
import com.example.taxidriver.domain.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RideApi {


    @POST("/api/ride")
    Call<RideDTO> submitRequestForRide(@Body RideRequestDTO rideRequestDTO);

    @PUT("/api/ride/{id}/accept")
    Call<Void> acceptRide(@Path("id") String id);

}
