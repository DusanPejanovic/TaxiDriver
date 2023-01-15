package com.example.taxidriver.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.taxidriver.R;
import com.example.taxidriver.data.repository.UserRepository;
import com.example.taxidriver.domain.model.User;
import com.example.taxidriver.ui.activities.driver.DriverMainActivity;
import com.example.taxidriver.ui.activities.passenger.PassengerMainActivity;
import com.example.taxidriver.domain.model.Driver;
import com.example.taxidriver.domain.model.Passenger;
import com.example.taxidriver.util.Mockup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        UserRepository repository = new UserRepository();
        repository.getUsers( new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> users = response.body();
                    // Do something with the user data

                    int z =3;
                } else {
                    // Handle error response
                    int w =2;
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                int a= 2;
                // Handle failure
            }
        });




    }





}