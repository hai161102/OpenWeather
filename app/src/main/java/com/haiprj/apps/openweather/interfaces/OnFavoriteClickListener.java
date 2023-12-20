package com.haiprj.apps.openweather.interfaces;

import com.haiprj.apps.openweather.model.Coordinate;
import com.haiprj.apps.openweather.model.CoordinateFavorite;

public interface OnFavoriteClickListener {
    void onClick(CoordinateFavorite coordinate);
}
