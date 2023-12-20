package com.haiprj.apps.openweather.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CoordinateFavorite")
public class CoordinateFavorite {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "lat")
    private Double lat;
    @ColumnInfo(name = "lon")
    private Double lon;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
