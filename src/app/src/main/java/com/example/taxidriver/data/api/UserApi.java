package com.example.taxidriver.data.api;

import com.example.taxidriver.data.dto.ChangePasswordCodeDTO;
import com.example.taxidriver.data.dto.LocationDTO3;
import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.data.dto.ResetPasswordDTO;
import com.example.taxidriver.domain.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserApi {
    @GET("api/user")
    Call<PaginatedResponse<User>> getUsers();

    @GET("api/user/location")
    Call<LocationDTO3> getCurrentLocation();


    @POST("/api/user/code")
    Call<Void> sendCode(@Body ResetPasswordDTO resetPasswordDTO);

    @PUT("/api/user/resetPassword")
    Call<Void> resetPassword(@Body ChangePasswordCodeDTO changePasswordCodeDTO);
}
