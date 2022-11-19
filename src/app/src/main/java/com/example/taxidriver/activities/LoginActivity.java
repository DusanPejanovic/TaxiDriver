package com.example.taxidriver.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.taxidriver.R;
import com.example.taxidriver.activities.driver.DriverMainActivity;
import com.example.taxidriver.activities.passenger.PassengerMainActivity;
import com.example.taxidriver.model.Driver;
import com.example.taxidriver.model.Passenger;
import com.example.taxidriver.tools.Mockup;

import java.util.List;

public class LoginActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login_button = findViewById(R.id.login_button);

        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent;

                Editable emailEditable = editTextEmail.getText();
                Editable passwordEditable = editTextPassword.getText();

                if(emailEditable == null || passwordEditable == null)
                    return;


                String email = emailEditable.toString();
                String password = passwordEditable.toString();

                intent = new Intent(LoginActivity.this, PassengerMainActivity.class);

                List<Passenger> passengers = Mockup.getPassengers();

                for (Passenger passenger : passengers)
                {
                    if(email.equals(passenger.getEmail()) && password.equals(passenger.getPassword()))
                    {
                        startActivity(intent);
                    }
                }

                intent = new Intent(LoginActivity.this, DriverMainActivity.class);

                List<Driver> drivers = Mockup.getDrivers();

                for (Driver driver : drivers)
                {
                    if(email.equals(driver.getEmail()) && password.equals(driver.getPassword()))
                    {
                        startActivity(intent);
                    }
                }
            }
        });


        Button register_button = findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }





}