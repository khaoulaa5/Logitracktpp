package com.example.logitrackk.network;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://your-api-base-url.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiService api() {
        return retrofit.create(ApiService.class);
    }
}
