package com.example.taxidriver.data.token;

import com.example.taxidriver.data.repository.AuthRepository;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    private AuthRepository auth;

    public TokenInterceptor(AuthRepository auth) {
        this.auth = auth;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (auth.tokenIsPresent()) {
            request = request.newBuilder().addHeader("Authorization", "Bearer " + auth.getToken()).build();
        }
        return chain.proceed(request);
    }
}

