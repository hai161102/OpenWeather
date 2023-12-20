package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class Sys implements Serializable {
  @SerializedName("country")
  private String country;
  @SerializedName("sunrise")
  private Integer sunrise;
  @SerializedName("sunset")
  private Integer sunset;
  @SerializedName("id")
  private Integer id;
  @SerializedName("type")
  private Integer type;
  @SerializedName("pod")
  private String pod;

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Integer getSunrise() {
    return this.sunrise;
  }

  public void setSunrise(Integer sunrise) {
    this.sunrise = sunrise;
  }

  public Integer getSunset() {
    return this.sunset;
  }

  public void setSunset(Integer sunset) {
    this.sunset = sunset;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getType() {
    return this.type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getPod() {
    return pod;
  }

  public void setPod(String pod) {
    this.pod = pod;
  }

  @Override
  public String toString() {
    return "Sys{" +
            "country='" + country + '\'' +
            ", sunrise=" + sunrise +
            ", sunset=" + sunset +
            ", id=" + id +
            ", type=" + type +
            ", pod='" + pod + '\'' +
            '}';
  }
}
