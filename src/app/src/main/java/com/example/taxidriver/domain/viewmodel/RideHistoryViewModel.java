package com.example.taxidriver.domain.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.data.repository.DriverRepository;
import com.example.taxidriver.domain.model.Ride;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RideHistoryViewModel extends ViewModel {

    private final DriverRepository driverRepository;

    private final MutableLiveData<List<Ride>> rideHistory;

    public RideHistoryViewModel() {
        driverRepository = new DriverRepository();
        rideHistory = new MutableLiveData<>();
    }

    public LiveData<List<Ride>> getRideHistory() {
        return rideHistory;
    }

    public void fetchRideHistory(String id) {
        driverRepository.getRideHistory(new Callback<PaginatedResponse<Ride>>() {
            @Override
            public void onResponse(Call<PaginatedResponse<Ride>> call, Response<PaginatedResponse<Ride>> response) {
                if (response.isSuccessful()) {
                    PaginatedResponse<Ride> rides = response.body();
                    // Do something with the user data

                    int z =3;
                } else {
                    // Handle error response
                    int w =2;
                }
            }

            @Override
            public void onFailure(Call<PaginatedResponse<Ride>> call, Throwable t) {

                int a = 2;
                // Handle failure
            }
        }, id);
    }
}
