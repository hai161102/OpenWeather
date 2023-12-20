package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class CurrentWeatherData implements Serializable {
  @SerializedName("rain")
  private Rain rain;
  @SerializedName("visibility")
  private Integer visibility;
  @SerializedName("timezone")
  private Integer timezone;
  @SerializedName("main")
  private Current current;
  @SerializedName("clouds")
  private Cloud cloud;
  @SerializedName("sys")
  private Sys sys;
  @SerializedName("dt")
  private Double date;
  @SerializedName("coord")
  private Coord coord;
  @SerializedName("weather")
  private List<Weather> weather;
  @SerializedName("name")
  private String name;
  @SerializedName("cod")
  private Integer code;
  @SerializedName("id")
  private Integer id;
  @SerializedName("base")
  private String base;
  @SerializedName("wind")
  private Wind wind;

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

  public Integer getTimezone() {
    return this.timezone;
  }

  public void setTimezone(Integer timezone) {
    this.timezone = timezone;
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

  public Double getDate() {
    return this.date;
  }

  public void setDate(Double date) {
    this.date = date;
  }

  public Coord getCoord() {
    return this.coord;
  }

  public void setCoord(Coord coord) {
    this.coord = coord;
  }

  public List<Weather> getWeather() {
    return this.weather;
  }

  public void setWeather(List<Weather> weather) {
    this.weather = weather;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCode() {
    return this.code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getBase() {
    return this.base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public Wind getWind() {
    return this.wind;
  }

  public void setWind(Wind wind) {
    this.wind = wind;
  }

  @Override
  public String toString() {
    return "CurrentWeatherData{" +
            "rain=" + (rain != null ? rain.toString() : "null") +
            ", visibility=" + visibility +
            ", timezone=" + timezone +
            ", main=" + current.toString() +
            ", clouds=" + cloud.toString() +
            ", sys=" + sys.toString() +
            ", dt=" + date +
            ", coord=" + coord.toString() +
            ", weather=" + weather +
            ", name='" + name + '\'' +
            ", cod=" + code +
            ", id=" + id +
            ", base='" + base + '\'' +
            ", wind=" + wind.toString() +
            '}';
  }
}
