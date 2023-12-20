package com.haiprj.apps.openweather.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.haiprj.apps.openweather.model.Coordinate;

import java.util.List;

@Dao
public interface DataCoordinate {

    @Query("select * from Coordinate")
    List<Coordinate> getAll();

    @Insert
    void insert(Coordinate coordinate);

    @Delete
    void delete(Coordinate coordinate);
}
