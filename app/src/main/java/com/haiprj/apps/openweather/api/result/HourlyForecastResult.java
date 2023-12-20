package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class HourlyForecastResult implements Serializable {
    @SerializedName("cod")
    private String code;
    @SerializedName("message")
    private Float message;
    @SerializedName("cnt")
    private Integer numberHours;
    @SerializedName("list")
    private List<Hourly> list;
    @SerializedName("city")
    private City city;

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

    public Integer getNumberHours() {
        return numberHours;
    }

    public void setNumberHours(Integer numberHours) {
        this.numberHours = numberHours;
    }

    public List<Hourly> getList() {
        return list;
    }

    public void setList(List<Hourly> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "HourlyForecastResult{" +
                "cod='" + code + '\'' +
                ", message=" + message +
                ", cnt=" + numberHours +
                ", list=" + list +
                ", city=" + city.toString() +
                '}';
    }
}
