package com.example.taxidriver.data.repository;

import com.example.taxidriver.data.api.AuthApi;
import com.example.taxidriver.data.RetrofitClient;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {
    private AuthApi authApi;
    private String access_token = "";

    public AuthRepository() {
        authApi = RetrofitClient.getInstance().create(AuthApi.class);
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

