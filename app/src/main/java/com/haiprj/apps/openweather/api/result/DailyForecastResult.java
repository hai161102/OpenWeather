package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DailyForecastResult implements Serializable {

    @SerializedName("city")
    private City city;
    @SerializedName("cod")
    private String code;
    @SerializedName("message")
    private Float message;
    @SerializedName("cnt")
    private Integer numberDay;
    @SerializedName("list")
    private List<Daily> dailyList;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getMessage() {
        return message;
    }

    public void setMessage(Float message) {
        this.message = message;
    }

    public Integer getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(Integer numberDay) {
        this.numberDay = numberDay;
    }

    public List<Daily> getDailyList() {
        return dailyList;
    }

    public void setDailyList(List<Daily> dailyList) {
        this.dailyList = dailyList;
    }

    @Override
    public String toString() {
        return "DailyForecastResult{" +
                "city=" + city.toString() +
                ", cod='" + code + '\'' +
                ", message=" + message +
                ", cnt=" + numberDay +
                '}';
    }
}
