package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Aqi implements Serializable {
    @SerializedName("aqi")
    private Float aqi;

    public Float getAqi() {
        return this.aqi;
    }

    public void setAqi(Float aqi) {
        this.aqi = aqi;
    }
}
