package com.haiprj.apps.openweather.api;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.haiprj.apps.openweather.api.result.AirPollution;
import com.haiprj.apps.openweather.api.result.CurrentWeatherData;
import com.haiprj.apps.openweather.api.result.DailyForecastResult;
import com.haiprj.apps.openweather.api.result.Geo;
import com.haiprj.apps.openweather.api.result.HourlyForecastResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("data/2.5/weather")
    Call<CurrentWeatherData> getCurrentWeatherData(
        @Query("lat") long lat,
        @Query("lon") long lon,
        @Query("appid") String api_key,
        @Nullable @Query("lang") String lang
    );
    @GET("data/2.5/weather")
    Call<CurrentWeatherData> getCurrentWeatherData(
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("appid") String api_key,
            @Nullable @Query("lang") String lang
    );

    @GET("data/2.5/weather")
    Call<CurrentWeatherData> getCurrentWeatherData(
            @Query("q") String location,
            @Query("appid") String api_key,
            @Nullable @Query("lang") String lang
    );
    @GET("data/2.5/weather")
    Call<CurrentWeatherData> getCurrentWeatherData(
            @Query("lat") long lat,
            @Query("lon") long lon,
            @Query("appid") String api_key
    );
    @GET("data/2.5/weather")
    Call<CurrentWeatherData> getCurrentWeatherData(
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("appid") String api_key
    );

    @GET("data/2.5/weather")
    Call<CurrentWeatherData> getCurrentWeatherData(
            @Query("q") String location,
            @Query("appid") String api_key
    );

    @GET("data/2.5/forecast/daily")
    Call<DailyForecastResult> getDailyForecast(
            @Query("lat") long lat,
            @Query("lon") long lon,
            @Query("appid") String api_key,
            @Query("cnt") int days,
            @Nullable @Query("lang") String lang
    );
    @GET("data/2.5/forecast/daily")
    Call<DailyForecastResult> getDailyForecast(
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("appid") String api_key,
            @Query("cnt") int days,
            @Nullable @Query("lang") String lang
    );

    @GET("data/2.5/forecast/daily")
    Call<DailyForecastResult> getDailyForecast(
            @Query("q") String location,
            @Query("appid") String api_key,
            @Query("cnt") int days,
            @Nullable @Query("lang") String lang
    );
    @GET("data/2.5/forecast/daily")
    Call<DailyForecastResult> getDailyForecast(
            @Query("lat") long lat,
            @Query("lon") long lon,
            @Query("appid") String api_key,
            @Query("cnt") int days
    );
    @GET("data/2.5/forecast/daily")
    Call<DailyForecastResult> getDailyForecast(
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("appid") String api_key,
            @Query("cnt") int days
    );

    @GET("data/2.5/forecast/daily")
    Call<DailyForecastResult> getDailyForecast(
            @Query("q") String location,
            @Query("appid") String api_key,
            @Query("cnt") int days
    );
    @GET("data/2.5/forecast/hourly")
    Call<HourlyForecastResult> getHourlyForecast(
            @Query("lat") long lat,
            @Query("lon") long lon,
            @Query("appid") String api_key,
            @Query("cnt") int hours,
            @Nullable @Query("lang") String lang
    );
    @GET("data/2.5/forecast/hourly")
    Call<HourlyForecastResult> getHourlyForecast(
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("appid") String api_key,
            @Query("cnt") int hours,
            @Nullable @Query("lang") String lang
    );
    @GET("data/2.5/forecast/hourly")
    Call<HourlyForecastResult> getHourlyForecast(
            @Query("q") String location,
            @Query("appid") String api_key,
            @Query("cnt") int hours,
            @Nullable @Query("lang") String lang
    );

    @GET("data/2.5/forecast/hourly")
    Call<HourlyForecastResult> getHourlyForecast(
            @Query("lat") long lat,
            @Query("lon") long lon,
            @Query("appid") String api_key,
            @Query("cnt") int hours
    );
    @GET("data/2.5/forecast/hourly")
    Call<HourlyForecastResult> getHourlyForecast(
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("appid") String api_key,
            @Query("cnt") int hours
    );
    @GET("data/2.5/forecast/hourly")
    Call<HourlyForecastResult> getHourlyForecast(
            @Query("q") String location,
            @Query("appid") String api_key,
            @Query("cnt") int hours
    );

    @GET("data/2.5/air_pollution")
    Call<AirPollution> getCurrentAQI(
            @Query("lat") long lat,
            @Query("lon") long lon,
            @Query("appid") String api_key
    );
    @GET("data/2.5/air_pollution")
    Call<AirPollution> getCurrentAQI(
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("appid") String api_key
    );

    @GET("data/2.5/air_pollution/forecast")
    Call<AirPollution> getWeatherAQI(
            @Query("lat") long lat,
            @Query("lon") long lon,
            @Query("appid") String api_key
    );
    @GET("data/2.5/air_pollution/forecast")
    Call<AirPollution> getWeatherAQI(
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("appid") String api_key
    );
    @GET("geo/1.0/direct")
    Call<List<Geo>> getLocations(
            @Query("q") String name,
            @Query("limit") int limit,
            @Query("appid") String api_key
    );
}
