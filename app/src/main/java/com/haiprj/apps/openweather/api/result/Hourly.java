package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class Hourly implements Serializable {
  @SerializedName("dt")
  private Long date;
  @SerializedName("pop")
  private Double pop;
  @SerializedName("rain")
  private Rain rain;
  @SerializedName("visibility")
  private Integer visibility;
  @SerializedName("dt_txt")
  private String dateString;
  @SerializedName("weather")
  private List<Weather> weather;
  @SerializedName("main")
  private Current current;
  @SerializedName("clouds")
  private Cloud cloud;
  @SerializedName("sys")
  private Sys sys;
  @SerializedName("wind")
  private Wind wind;

  public Long getDate() {
    return this.date;
  }

  public void setDate(Long date) {
    this.date = date;
  }

  public Double getPop() {
    return this.pop;
  }

  public void setPop(Double pop) {
    this.pop = pop;
  }

  public Rain getRain() {
    return this.rain;
  }

  public void setRain(Rain rain) {
    this.rain = rain;
  }

  public Integer getVisibility() {
    return this.visibility;
  }

  public void setVisibility(Integer visibility) {
    this.visibility = visibility;
  }

  public String getDateString() {
    return this.dateString;
  }

  public void setDateString(String dateString) {
    this.dateString = dateString;
  }

  public List<Weather> getWeather() {
    return this.weather;
  }

  public void setWeather(List<Weather> weather) {
    this.weather = weather;
  }

  public Current getCurrent() {
    return this.current;
  }

  public void setCurrent(Current current) {
    this.current = current;
  }

  public Cloud getCloud() {
    return this.cloud;
  }

  public void setCloud(Cloud cloud) {
    this.cloud = cloud;
  }

  public Sys getSys() {
    return this.sys;
  }

  public void setSys(Sys sys) {
    this.sys = sys;
  }

  public Wind getWind() {
    return this.wind;
  }

  public void setWind(Wind wind) {
    this.wind = wind;
  }


  @Override
  public String toString() {
    return "Hourly{" +
            "dt=" + date +
            ", pop=" + pop +
            ", rain=" + rain.toString() +
            ", visibility=" + visibility +
            ", dt_txt='" + dateString + '\'' +
            ", weather=" + weather +
            ", main=" + current.toString() +
            ", clouds=" + cloud.toString() +
            ", sys=" + sys.toString() +
            ", wind=" + wind.toString() +
            '}';
  }
}
