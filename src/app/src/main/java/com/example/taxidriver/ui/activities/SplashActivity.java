package com.example.taxidriver.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.taxidriver.R;
import com.example.taxidriver.TaxiDriver;
import com.example.taxidriver.util.Tools;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int SPLASH_TIME_OUT = 1500;

        if (Tools.getConnectivityStatus(getApplicationContext()) == 0) {
            Toast.makeText(TaxiDriver.getAppContext(), "Turn on wifi or mobile data.", Toast.LENGTH_SHORT).show();
            SPLASH_TIME_OUT = 10000;
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                int status = Tools.getConnectivityStatus(getApplicationContext());
                if (Tools.getConnectivityStatus(getApplicationContext())  != 0) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
                finish();
            }
        }, SPLASH_TIME_OUT);


    }
}