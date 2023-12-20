package com.haiprj.apps.openweather.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfigs {
    private static ApiConfigs instance;
    public static final String BASE_URL = "https://pro.openweathermap.org/";
    public static final String API_KEY = "4d991ce55e9e4754a76f15f059071691";

    public Retrofit retrofit;
    public ApiServices apiServices;
    public static ApiConfigs getInstance() {
        if (ApiConfigs.instance == null) ApiConfigs.instance = new ApiConfigs();
        return instance;
    }

    private ApiConfigs() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.apiServices = this.retrofit.create(ApiServices.class);
    }
}
