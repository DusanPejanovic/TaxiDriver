package com.example.taxidriver.domain.viewmodel;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taxidriver.TaxiDriver;
import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.data.dto.RideDTO;
import com.example.taxidriver.data.repository.DriverRepository;
import com.example.taxidriver.data.repository.RideRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RideHistoryDetailViewModel extends ViewModel {

    private final RideRepository rideRepository;

    private MutableLiveData<RideDTO> ride;

    public RideHistoryDetailViewModel() {
        rideRepository = new RideRepository();
        ride = new MutableLiveData<>();
    }

    public LiveData<RideDTO> getRide() {
        return ride;
    }

    public void fetchRide(String id) {
        rideRepository.getRide(new Callback<RideDTO>() {
            @Override
            public void onResponse(@NonNull Call<RideDTO> call, @NonNull Response<RideDTO> response) {
                if (response.isSuccessful()) {
                    RideDTO rideDTO = response.body();
                    assert rideDTO != null;
                    Toast.makeText(TaxiDriver.getAppContext(), "Ride Detail, success", Toast.LENGTH_SHORT).show();
                    ride.postValue(rideDTO);


                } else {
                    Toast.makeText(TaxiDriver.getAppContext(), "Ride Detail, response body wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<RideDTO> call, Throwable t) {
              Toast.makeText(TaxiDriver.getAppContext(), "Ride Detail, on failure.", Toast.LENGTH_SHORT).show();
            }
        }, id);
    }
}
