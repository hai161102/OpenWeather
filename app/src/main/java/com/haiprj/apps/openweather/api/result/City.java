package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;

public class City implements Serializable {
  @SerializedName("country")
  private String country;
  @SerializedName("coord")
  private Coord coord;
  @SerializedName("timezone")
  private Integer timezone;
  @SerializedName("name")
  private String name;
  @SerializedName("id")
  private Integer id;
  @SerializedName("population")
  private Integer population;
  @SerializedName("sunrise")
  private Double sunrise;
  @SerializedName("sunset")
  private Double sunset;

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Coord getCoord() {
    return this.coord;
  }

  public void setCoord(Coord coord) {
    this.coord = coord;
  }

  public Integer getTimezone() {
    return this.timezone;
  }

  public void setTimezone(Integer timezone) {
    this.timezone = timezone;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPopulation() {
    return this.population;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }

  public Double getSunrise() {
    return sunrise;
  }

  public void setSunrise(Double sunrise) {
    this.sunrise = sunrise;
  }

  public Double getSunset() {
    return sunset;
  }

  public void setSunset(Double sunset) {
    this.sunset = sunset;
  }

  @Override
  public String toString() {
    return "City{" +
            "country='" + country + '\'' +
            ", coord=" + coord +
            ", timezone=" + timezone +
            ", name='" + name + '\'' +
            ", id=" + id +
            ", population=" + population +
            ", sunrise=" + sunrise +
            ", sunset=" + sunset +
            '}';
  }
}
