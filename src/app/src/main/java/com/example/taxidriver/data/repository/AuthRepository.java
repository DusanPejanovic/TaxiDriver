package com.example.taxidriver.data.repository;

import com.example.taxidriver.data.api.AuthApi;
import com.example.taxidriver.data.RetrofitClient;
import com.example.taxidriver.data.token.TokenInterceptor;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthRepository {
    private AuthApi authApi;
    private String access_token = "";

    public AuthRepository() {
        String BASE_URL = "http://10.0.2.2:8080/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        authApi = retrofit.create(AuthApi.class);
    }

    public void login(String email, String password, final AuthCallback authCallback) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("password", password);

        Call<JsonObject> call = authApi.login(jsonObject);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    access_token = response.body().get("access_token").getAsString();
                    authCallback.onSuccess();
                } else {
                    authCallback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                authCallback.onFailure(t.getMessage());
            }
        });
    }

    public void signup(String email, String password, final AuthCallback authCallback) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("password", password);

        Call<Void> call = authApi.signup(jsonObject);
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
        access_token = "";
    }

    public boolean tokenIsPresent() {
        return access_token.isEmpty();
    }

    public String getToken() {
        return access_token;
    }

    public interface AuthCallback {
        void onSuccess();
        void onFailure(String message);
    }
}

