package com.haiprj.apps.openweather.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.haiprj.apps.openweather.model.Coordinate;
import com.haiprj.apps.openweather.model.CoordinateFavorite;
import com.haiprj.apps.openweather.model.GeoData;

@Database(entities = {Coordinate.class, CoordinateFavorite.class, GeoData.class}, version = 6)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataCoordinate dataCoordinate();
    public abstract DataCoordinateFavorite dataCoordinateFavorite();
    public abstract DataSearch dataSearch();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "location").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }
    public static AppDatabase getInstance() {return instance;}
}
