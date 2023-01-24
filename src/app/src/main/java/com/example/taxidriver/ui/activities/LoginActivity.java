package com.example.taxidriver.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taxidriver.R;
import com.example.taxidriver.TaxiDriver;
import com.example.taxidriver.data.repository.AuthRepository;
import com.example.taxidriver.data.repository.UserRepository;
import com.example.taxidriver.domain.model.User;
import com.example.taxidriver.ui.activities.driver.DriverMainActivity;
import com.example.taxidriver.ui.activities.passenger.PassengerMainActivity;
import com.example.taxidriver.domain.model.Driver;
import com.example.taxidriver.domain.model.Passenger;
import com.example.taxidriver.util.Mockup;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    AuthRepository authRepository = new AuthRepository();
    SharedPreferences pref = TaxiDriver.getAppContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);



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
                Editable emailEditable = editTextEmail.getText();
                Editable passwordEditable = editTextPassword.getText();

                if(emailEditable == null || passwordEditable == null)
                    return;

                String email = emailEditable.toString();
                String password = passwordEditable.toString();

                authRepository.login(email, password,new Callback<JsonObject>() {
                    @Override
                    public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                        if (response.isSuccessful()) {

                            assert response.body() != null;

                            String token = response.body().get("accessToken").getAsString();
                            String role = response.body().get("role").getAsString();
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("token", token);
                            editor.apply();

                            if(Objects.equals(role, "ROLE_DRIVER"))
                            {
                                startActivity(new Intent(LoginActivity.this, DriverMainActivity.class));
                            }
                            else if(role.equals("ROLE_PASSENGER"))
                            {
                                startActivity(new Intent(LoginActivity.this, PassengerMainActivity.class));
                            }

                        } else {
                            Toast.makeText(TaxiDriver.getAppContext(), "Email or password is incorrect.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<JsonObject> call, Throwable t) {
                        Toast.makeText(TaxiDriver.getAppContext(), "Email or password is incorrect.", Toast.LENGTH_SHORT).show();
                    }
                });
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
    public void forgotPassword(View view) {
        // inflate the layout
        final Dialog forgotPasswordDialogView = new Dialog(LoginActivity.this);
        forgotPasswordDialogView.setContentView(R.layout.forgot_password_dialog);
        final EditText emailEditText = forgotPasswordDialogView.findViewById(R.id.email_edit_text);
        Button sendButton = forgotPasswordDialogView.findViewById(R.id.send_button);

        sendButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                if (!TextUtils.isEmpty(email)) {
                    // Send password reset link to email
                    // Show message to user that link was sent
                    final Dialog resetDialog = new Dialog(LoginActivity.this);
                    resetDialog.setContentView(R.layout.reset_password_dialog);
                    resetDialog.setTitle("Reset Password");
                    final EditText codeEditText = resetDialog.findViewById(R.id.reset_code_edit_text);
                    final EditText passwordEditText = resetDialog.findViewById(R.id.new_password_edit_text);
                    Button submitButton = resetDialog.findViewById(R.id.submit_button);
                    submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String code = codeEditText.getText().toString();
                            String newPassword = passwordEditText.getText().toString();
                            // Verify the code and update the user's password
                            // Show message to user that password was reset
                            resetDialog.dismiss();
                        }
                    });

                    resetDialog.show();
                    forgotPasswordDialogView.dismiss();

                } else {
                    // Show message to user that email is empty
                }
        }
        });

        forgotPasswordDialogView.show();


    }



}