package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FeelsLike implements Serializable {
  @SerializedName("eve")
  private Float eve;
  @SerializedName("night")
  private Float night;
  @SerializedName("day")
  private Float day;
  @SerializedName("morn")
  private Float morn;

  public Float getEve() {
    return this.eve;
  }

  public void setEve(Float eve) {
    this.eve = eve;
  }

  public Float getNight() {
    return this.night;
  }

  public void setNight(Float night) {
    this.night = night;
  }

  public Float getDay() {
    return this.day;
  }

  public void setDay(Float day) {
    this.day = day;
  }

  public Float getMorn() {
    return this.morn;
  }

  public void setMorn(Float morn) {
    this.morn = morn;
  }

  @Override
  public String toString() {
    return "FeelsLike{" +
            "eve=" + eve +
            ", night=" + night +
            ", day=" + day +
            ", morn=" + morn +
            '}';
  }
}
