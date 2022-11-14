package com.example.taxidriver.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.taxidriver.R;
import com.example.taxidriver.fragments.MyFragment;
import com.example.taxidriver.tools.FragmentTransition;


public class DriverRideHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_ride_history);

    }
}