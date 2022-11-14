package com.example.taxidriver.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taxidriver.R;


public class DriverMainActivity extends AppCompatActivity {
    private boolean togleValue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main);


        Button login_button = findViewById(R.id.online_ofline_button);
        TextView online_ofline_text_view = findViewById(R.id.online_ofline_text_view);

        ImageView home = findViewById(R.id.home);
        ImageView history = findViewById(R.id.history);
        ImageView inbox = findViewById(R.id.inbox);
        ImageView profile = findViewById(R.id.profile);

//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(DriverMainActivity.this, DriverMainActivity.class));
//            }
//        });

//        history.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(DriverMainActivity.this, PassengerHistoryFragment.class));
//            }
//        });
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DriverMainActivity.this, InboxActivityDriver.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DriverMainActivity.this, PassengerAccountActivity.class));
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(togleValue == false)
                {
                  online_ofline_text_view.setText("online");
                  togleValue = true;
                }
                else
                {
                    online_ofline_text_view.setText("offline");
                    togleValue = false;
                }


            }
        });



    }
}