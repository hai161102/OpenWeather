package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;

public class Current implements Serializable {
  @SerializedName("temp")
  private Float temp;
  @SerializedName("temp_min")
  private Float tempMin;
  @SerializedName("grnd_level")
  private Integer grndLevel;
  @SerializedName("temp_kf")
  private Float tempKF;
  @SerializedName("humidity")
  private Integer humidity;
  @SerializedName("pressure")
  private Integer pressure;
  @SerializedName("sea_level")
  private Integer seaLevel;
  @SerializedName("feels_like")
  private Float feelsLike;
  @SerializedName("temp_max")
  private Float tempMax;

  public Float getTemp() {
    return this.temp;
  }

  public void setTemp(Float temp) {
    this.temp = temp;
  }

  public Float getTempMin() {
    return this.tempMin;
  }

  public void setTempMin(Float tempMin) {
    this.tempMin = tempMin;
  }

  public Integer getGrndLevel() {
    return this.grndLevel;
  }

  public void setGrndLevel(Integer grndLevel) {
    this.grndLevel = grndLevel;
  }

  public Float getTempKF() {
    return this.tempKF;
  }

  public void setTempKF(Float tempKF) {
    this.tempKF = tempKF;
  }

  public Integer getHumidity() {
    return this.humidity;
  }

  public void setHumidity(Integer humidity) {
    this.humidity = humidity;
  }

  public Integer getPressure() {
    return this.pressure;
  }

  public void setPressure(Integer pressure) {
    this.pressure = pressure;
  }

  public Integer getSeaLevel() {
    return this.seaLevel;
  }

  public void setSeaLevel(Integer seaLevel) {
    this.seaLevel = seaLevel;
  }

  public Float getFeelsLike() {
    return this.feelsLike;
  }

  public void setFeelsLike(Float feelsLike) {
    this.feelsLike = feelsLike;
  }

  public Float getTempMax() {
    return this.tempMax;
  }

  public void setTempMax(Float tempMax) {
    this.tempMax = tempMax;
  }

  @Override
  public String toString() {
    return "Current{" +
            "temp=" + temp +
            ", temp_min=" + tempMin +
            ", grnd_level=" + grndLevel +
            ", temp_kf=" + tempKF +
            ", humidity=" + humidity +
            ", pressure=" + pressure +
            ", sea_level=" + seaLevel +
            ", feels_like=" + feelsLike +
            ", temp_max=" + tempMax +
            '}';
  }
}
