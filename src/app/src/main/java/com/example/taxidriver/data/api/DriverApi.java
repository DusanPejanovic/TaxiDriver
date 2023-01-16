package com.example.taxidriver.data.api;

import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.domain.model.Ride;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DriverApi {
    @GET("api/driver/{id}/ride")
    Call<PaginatedResponse<Ride>> getRideHistory(@Path("id") String id);
}
