package com.example.taxidriver.ui.activities.driver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.taxidriver.R;
import com.example.taxidriver.domain.viewmodel.RideHistoryDetailViewModel;
import com.example.taxidriver.ui.fragments.HistoryFragment;

public class DriverHistoryDetailActivity extends AppCompatActivity {

    RideHistoryDetailViewModel rideHistoryDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_history_detail);

        rideHistoryDetailViewModel = new RideHistoryDetailViewModel();

        rideHistoryDetailViewModel.getRide().observe(this, rideDTO -> {

                    if(rideDTO != null)
                    {
                        // inflate view
                    }
                }
        );
/*

        TextView cost = findViewById(R.id.cost);
        TextView mileage = findViewById(R.id.mileage);
        TextView startTime = findViewById(R.id.startTime);
        TextView endTime = findViewById(R.id.endTime);
        TextView startPoint = findViewById(R.id.startPoint);
        TextView endPoint = findViewById(R.id.endPoint);
        TextView comment = findViewById(R.id.comment);
        TextView grade = findViewById(R.id.grade);
        TextView passenger = findViewById(R.id.pasenger);
        */


    }
}