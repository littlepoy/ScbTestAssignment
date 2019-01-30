package com.example.scb.model;

import android.content.Context;
import com.example.scb.model.api.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestClient {

    private static API api;

    public static API ApiService() {
        api = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build()
                .create(API.class);
        return api;
    }
}
