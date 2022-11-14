package com.example.taxidriver.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.taxidriver.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class InboxActivityPassenger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox_passenger);


        ImageView home = findViewById(R.id.home);
        ImageView history = findViewById(R.id.history);
        ImageView inbox = findViewById(R.id.inbox);
        ImageView profile = findViewById(R.id.profile);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InboxActivityPassenger.this, PassengerMainActivity.class));
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(PassengerMainActivity.this, PassengerHistoryFragment.class));
                Toast.makeText(InboxActivityPassenger.this, "TODO: Add passenger ride history", Toast.LENGTH_SHORT).show();
            }
        });
//        inbox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(InboxActivityPassenger.this, InboxActivityPassenger.class));
//            }
//        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InboxActivityPassenger.this, PassengerAccountActivity.class));
            }
        });
    }
}