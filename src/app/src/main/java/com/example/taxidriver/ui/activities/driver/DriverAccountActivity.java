package com.example.taxidriver.ui.activities.driver;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.taxidriver.R;
import com.example.taxidriver.TaxiDriver;
import com.example.taxidriver.domain.viewmodel.RideHistoryViewModel;
import com.example.taxidriver.ui.fragments.HistoryFragment;

public class DriverAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_account);


        ImageView home = findViewById(R.id.home);
        ImageView inbox = findViewById(R.id.inbox);
        ImageView profile = findViewById(R.id.profile);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DriverAccountActivity.this, DriverMainActivity.class));
                finish();
            }
        });


        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DriverAccountActivity.this, DriverInboxActivity.class));
                finish();

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DriverAccountActivity.this, DriverAccountActivity.class));
                finish();

            }
        });

    }
}