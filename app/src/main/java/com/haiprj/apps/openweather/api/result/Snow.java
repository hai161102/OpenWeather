package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Snow implements Serializable {
    @SerializedName("1h")
    private Float oneHour;
    @SerializedName("3h")
    private Float threeHours;

    public Float getOneHour() {
        return oneHour;
    }

    public void setOneHour(Float oneHour) {
        this.oneHour = oneHour;
    }

    public Float getThreeHours() {
        return threeHours;
    }

    public void setThreeHours(Float threeHours) {
        this.threeHours = threeHours;
    }

    @Override
    public String toString() {
        return "Snow{" +
                "oneHour=" + oneHour +
                ", threeHours=" + threeHours +
                '}';
    }
}
