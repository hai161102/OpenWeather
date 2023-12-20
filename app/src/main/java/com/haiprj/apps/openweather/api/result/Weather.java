package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class Weather implements Serializable {
  @SerializedName("icon")
  private String icon;
  @SerializedName("description")
  private String description;
  @SerializedName("main")
  private String main;
  @SerializedName("id")
  private Integer id;

  public String getIcon() {
    return this.icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getMain() {
    return this.main;
  }

  public void setMain(String main) {
    this.main = main;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Weather{" +
            "icon='" + icon + '\'' +
            ", description='" + description + '\'' +
            ", main='" + main + '\'' +
            ", id=" + id +
            '}';
  }
}
