package com.haiprj.apps.openweather.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.haiprj.apps.openweather.model.CoordinateFavorite;

import java.util.List;

@Dao
public interface DataCoordinateFavorite {

    @Query("select * from CoordinateFavorite")
    List<CoordinateFavorite> getAll();

    @Insert
    void insert(CoordinateFavorite coordinate);

    @Delete
    void delete(CoordinateFavorite coordinate);
}
