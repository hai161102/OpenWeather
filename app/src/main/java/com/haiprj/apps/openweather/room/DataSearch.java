package com.haiprj.apps.openweather.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.haiprj.apps.openweather.model.GeoData;

import java.util.List;

@Dao
public interface DataSearch {
    @Query("select * from GeoData limit 10")
    List<GeoData> gets();

    @Insert
    void add(GeoData data);
    @Delete
    void delete(GeoData data);
}
