package com.example.taxidriver.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.taxidriver.R;
public class InboxActivityDriver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox_driver);

        ImageView home = findViewById(R.id.home);
        ImageView history = findViewById(R.id.history);
        ImageView inbox = findViewById(R.id.inbox);
        ImageView profile = findViewById(R.id.profile);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InboxActivityDriver.this, DriverMainActivity.class));
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(DriverMainActivity.this, PassengerHistoryFragment.class));
                Toast.makeText(InboxActivityDriver.this, "TODO: Add driver history", Toast.LENGTH_SHORT).show();
            }
        });
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InboxActivityDriver.this, InboxActivityDriver.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(DriverMainActivity.this, PassengerAccountActivity.class));
                Toast.makeText(InboxActivityDriver.this, "TODO: Add driver account", Toast.LENGTH_SHORT).show();
            }
        });

    }
}