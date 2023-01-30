package com.example.taxidriver.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.taxidriver.R;
import com.example.taxidriver.data.dto.PaginatedResponse;
import com.example.taxidriver.data.repository.UserRepository;
import com.example.taxidriver.domain.model.User;
import com.example.taxidriver.ui.activities.passenger.PassengerMainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(RegisterActivity.this, PassengerMainActivity.class);
                startActivity(intent);
            }
        });

    }


}