package com.haiprj.apps.openweather.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.haiprj.apps.openweather.api.result.Geo;

@Entity(tableName = "GeoData")
public class GeoData {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo( name = "country")
    private String country;
    @ColumnInfo( name = "name")
    private String name;
    @ColumnInfo( name = "lon")
    private Double lon;
    @ColumnInfo( name = "state")
    private String state;
    @ColumnInfo( name = "lat")
    private Double lat;

    public GeoData() {
    }

    public GeoData set(Geo geo) {
        this.country = geo.getCountry();
        this.name = geo.getName();
        this.lon = geo.getLon();
        this.state = geo.getState();
        this.lat = geo.getLat();
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
