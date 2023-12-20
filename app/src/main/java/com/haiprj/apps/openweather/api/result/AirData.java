package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AirData implements Serializable {
    @SerializedName("dt")
    private Double date;
    @SerializedName("components")
    private Components components;
    @SerializedName("main")
    private Aqi aqi;

    public Double getDate() {
      return this.date;
    }

    public void setDate(Double date) {
      this.date = date;
    }

    public Components getComponents() {
      return this.components;
    }

    public void setComponents(Components components) {
      this.components = components;
    }

    public Aqi getAqi() {
      return this.aqi;
    }

    public void setAqi(Aqi aqi) {
      this.aqi = aqi;
    }
    
}