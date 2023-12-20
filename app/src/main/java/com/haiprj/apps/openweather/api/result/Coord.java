package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Coord implements Serializable {
    @SerializedName("lat")
    private Double lat;
    @SerializedName("lon")
    private Double lon;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
