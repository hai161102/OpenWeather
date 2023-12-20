package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
public class Daily implements Serializable {
  @SerializedName("rain")
  private Float rain;
  @SerializedName("sunrise")
  private Integer sunrise;
  @SerializedName("temp")
  private Temp temp;
  @SerializedName("deg")
  private Integer deg;
  @SerializedName("pressure")
  private Integer pressure;
  @SerializedName("clouds")
  private Integer clouds;
  @SerializedName("feels_like")
  private FeelsLike feelsLike;
  @SerializedName("speed")
  private Float speed;
  @SerializedName("dt")
  private Long date;
  @SerializedName("pop")
  private Float pop;
  @SerializedName("sunset")
  private Integer sunset;
  @SerializedName("weather")
  private List<Weather> weather;
  @SerializedName("humidity")
  private Integer humidity;
  @SerializedName("gust")
  private Float gust;

  public Float getRain() {
    return this.rain;
  }

  public void setRain(Float rain) {
    this.rain = rain;
  }

  public Integer getSunrise() {
    return this.sunrise;
  }

  public void setSunrise(Integer sunrise) {
    this.sunrise = sunrise;
  }

  public Temp getTemp() {
    return this.temp;
  }

  public void setTemp(Temp temp) {
    this.temp = temp;
  }

  public Integer getDeg() {
    return this.deg;
  }

  public void setDeg(Integer deg) {
    this.deg = deg;
  }

  public Integer getPressure() {
    return this.pressure;
  }

  public void setPressure(Integer pressure) {
    this.pressure = pressure;
  }

  public Integer getClouds() {
    return this.clouds;
  }

  public void setClouds(Integer clouds) {
    this.clouds = clouds;
  }

  public FeelsLike getFeelsLike() {
    return this.feelsLike;
  }

  public void setFeelsLike(FeelsLike feelsLike) {
    this.feelsLike = feelsLike;
  }

  public Float getSpeed() {
    return this.speed;
  }

  public void setSpeed(Float speed) {
    this.speed = speed;
  }

  public Long getDate() {
    return this.date;
  }

  public void setDate(Long date) {
    this.date = date;
  }

  public Float getPop() {
    return this.pop;
  }

  public void setPop(Float pop) {
    this.pop = pop;
  }

  public Integer getSunset() {
    return this.sunset;
  }

  public void setSunset(Integer sunset) {
    this.sunset = sunset;
  }

  public List<Weather> getWeather() {
    return this.weather;
  }

  public void setWeather(List<Weather> weather) {
    this.weather = weather;
  }

  public Integer getHumidity() {
    return this.humidity;
  }

  public void setHumidity(Integer humidity) {
    this.humidity = humidity;
  }

  public Float getGust() {
    return this.gust;
  }

  public void setGust(Float gust) {
    this.gust = gust;
  }

  @Override
  public String toString() {
    return "Daily{" +
            "rain=" + rain.toString() +
            ", sunrise=" + sunrise +
            ", temp=" + temp.toString() +
            ", deg=" + deg +
            ", pressure=" + pressure +
            ", clouds=" + clouds.toString() +
            ", feels_like=" + feelsLike.toString() +
            ", speed=" + speed +
            ", dt=" + date +
            ", pop=" + pop +
            ", sunset=" + sunset +
            ", weather=" + weather +
            ", humidity=" + humidity +
            ", gust=" + gust +
            '}';
  }
}
