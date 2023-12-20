package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;

public class Wind implements Serializable {
  @SerializedName("deg")
  private Integer deg;
  @SerializedName("speed")
  private Float speed;
  @SerializedName("gust")
  private Float gust;

  public Integer getDeg() {
    return this.deg;
  }

  public void setDeg(Integer deg) {
    this.deg = deg;
  }

  public Float getSpeed() {
    return this.speed;
  }

  public void setSpeed(Float speed) {
    this.speed = speed;
  }

  public Float getGust() {
    return this.gust;
  }

  public void setGust(Float gust) {
    this.gust = gust;
  }

  @Override
  public String toString() {
    return "Wind{" +
            "deg=" + deg +
            ", speed=" + speed +
            ", gust=" + gust +
            '}';
  }
}
