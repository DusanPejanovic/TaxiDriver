package com.example.taxidriver.data.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.taxidriver.TaxiDriver;
import com.example.taxidriver.data.api.AuthApi;
import com.example.taxidriver.domain.model.User;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthRepository {
    private final AuthApi authApi;
    SharedPreferences pref = TaxiDriver.getAppContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);


    public AuthRepository() {
        String BASE_URL = "http://10.0.2.2:8080/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        authApi = retrofit.create(AuthApi.class);
    }

    public void login(String username, String password) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", username);
        jsonObject.addProperty("password", password);

        Call<JsonObject> call = authApi.login(jsonObject);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {

                    String token = response.body().get("accessToken").getAsString();
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("token", token);
                    editor.apply();

                } else {
                    int x =2;
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
              int x = 2;
            }
        });
    }

    public void signup(User user, final AuthCallback authCallback) {

        Call<Void> call = authApi.signup(user);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    authCallback.onSuccess();
                } else {
                    authCallback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                authCallback.onFailure(t.getMessage());
            }
        });
    }

    public void logout() {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("token", null);
        editor.apply();
    }




    public interface AuthCallback {
        void onSuccess();
        void onFailure(String message);
    }
}

