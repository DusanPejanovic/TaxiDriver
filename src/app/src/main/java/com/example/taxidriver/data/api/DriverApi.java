package com.example.taxidriver.data.api;

import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.data.dto.RideDTO;
import com.example.taxidriver.domain.model.Ride;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DriverApi {
    @GET("api/driver/{id}/ride?page=&size&from=2011-12-03T10:15:30&to=2022-09-21T19:14:26")
    Call<PaginatedResponse<RideDTO>> getRideHistory(@Path("id") String id);
}
