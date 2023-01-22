package com.example.taxidriver.ui.activities.driver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.taxidriver.R;
import com.example.taxidriver.data.dto.RideDTO;
import com.example.taxidriver.data.repository.DriverRepository;
import com.example.taxidriver.domain.viewmodel.RideHistoryViewModel;
import com.example.taxidriver.ui.fragments.HistoryFragment;

import java.util.ArrayList;
import java.util.List;

public class DriverHistoryActivity extends AppCompatActivity {

    private RideHistoryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_history);

        viewModel = new ViewModelProvider(this).get(RideHistoryViewModel.class);

        viewModel.getRideHistory().observe(this, rideHistory -> {

                FragmentManager fragmentManager = getSupportFragmentManager();

                HistoryFragment historyFragment = HistoryFragment.newInstance(rideHistory);


                fragmentManager.beginTransaction().add(R.id.mainContent, historyFragment).commit();

        });

        DriverRepository driverRepository = new DriverRepository();




        ImageView home = findViewById(R.id.home);
        ImageView inbox = findViewById(R.id.inbox);
        ImageView profile = findViewById(R.id.profile);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DriverHistoryActivity.this, DriverMainActivity.class));
            }
        });


        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DriverHistoryActivity.this, DriverInboxActivity.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(DriverHistoryActivity.this, PassengerAccountActivity.class));
                Toast.makeText(DriverHistoryActivity.this, "TODO: Add driver account", Toast.LENGTH_SHORT).show();
            }
        });

        RideHistoryViewModel rideHistoryViewModel = new RideHistoryViewModel();

        rideHistoryViewModel.fetchRideHistory("1");






    }
}