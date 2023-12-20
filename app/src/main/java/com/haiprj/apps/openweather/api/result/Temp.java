package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.Double;

public class Temp implements Serializable {
  @SerializedName("min")
  private Float min;
  @SerializedName("max")
  private Float max;
  @SerializedName("eve")
  private Float eve;
  @SerializedName("night")
  private Float night;
  @SerializedName("day")
  private Float day;
  @SerializedName("morn")
  private Float morn;

  public Float getMin() {
    return this.min;
  }

  public void setMin(Float min) {
    this.min = min;
  }

  public Float getMax() {
    return this.max;
  }

  public void setMax(Float max) {
    this.max = max;
  }

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
    return "Temp{" +
            "min=" + min +
            ", max=" + max +
            ", eve=" + eve +
            ", night=" + night +
            ", day=" + day +
            ", morn=" + morn +
            '}';
  }
}
