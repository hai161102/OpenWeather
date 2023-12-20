package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AirPollution implements Serializable {
  @SerializedName("coord")
  private Coord coord;
  @SerializedName("list")
  private List<AirData> airData;

  public Coord getCoord() {
    return this.coord;
  }

  public void setCoord(Coord coord) {
    this.coord = coord;
  }

  public List<AirData> getList() {
    return this.airData;
  }

  public void setList(List<AirData> airData) {
    this.airData = airData;
  }


}
