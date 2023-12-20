package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.String;

public class Geo implements Serializable {
  @SerializedName("local_names")
  private LocalNames localNames;
  @SerializedName("country")
  private String country;
  @SerializedName("name")
  private String name;
  @SerializedName("lon")
  private Double lon;
  @SerializedName("state")
  private String state;
  @SerializedName("lat")
  private Double lat;

  public LocalNames getLocalNames() {
    return localNames;
  }

  public void setLocalNames(LocalNames localNames) {
    this.localNames = localNames;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getLon() {
    return this.lon;
  }

  public void setLon(Double lon) {
    this.lon = lon;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Double getLat() {
    return this.lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }


}
