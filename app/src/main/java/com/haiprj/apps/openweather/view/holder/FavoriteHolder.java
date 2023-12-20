package com.haiprj.apps.openweather.view.holder;

import android.content.Context;

import androidx.annotation.NonNull;

import com.haiprj.apps.openweather.api.ApiConfigs;
import com.haiprj.apps.openweather.api.result.Coord;
import com.haiprj.apps.openweather.api.result.CurrentWeatherData;
import com.haiprj.apps.openweather.base.BaseHolder;
import com.haiprj.apps.openweather.databinding.ItemSearchBinding;
import com.haiprj.apps.openweather.interfaces.OnFavoriteClickListener;
import com.haiprj.apps.openweather.model.Coordinate;
import com.haiprj.apps.openweather.model.CoordinateFavorite;
import com.haiprj.apps.openweather.room.AppDatabase;
import com.haiprj.apps.openweather.utils.AppUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteHolder extends BaseHolder<ItemSearchBinding, CoordinateFavorite> {

    private OnFavoriteClickListener listener;

    public FavoriteHolder setListener(OnFavoriteClickListener listener) {
        this.listener = listener;
        return this;
    }

    public FavoriteHolder(Context context, @NonNull ItemSearchBinding binding) {
        super(context, binding);
    }

    @Override
    public void load(CoordinateFavorite data) {
        ApiConfigs.getInstance().apiServices.getCurrentWeatherData(
                data.getLat(),
                data.getLon(),
                ApiConfigs.API_KEY,
                "vi"
        ).enqueue(new Callback<CurrentWeatherData>() {
            @Override
            public void onResponse(@NonNull Call<CurrentWeatherData> call, @NonNull Response<CurrentWeatherData> response) {
                if (response.isSuccessful() && response.body() != null) {
                    FavoriteHolder.this.updateUI(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CurrentWeatherData> call, @NonNull Throwable t) {

            }
        });
        this.binding.deleteBtn.setOnClickListener(v -> {
            if (AppDatabase.getInstance().dataCoordinate().getAll().contains(data)) {
            }
            AppDatabase.getInstance().dataCoordinateFavorite().delete(data);
            this.getAdapter().getList().remove(data);
            this.getAdapter().notifyItemRemoved(getAdapterPosition());


        });
        this.binding.getRoot().setOnClickListener(v -> {
            if (listener != null) {
                listener.onClick(data);
            }
        });
    }

    private void updateUI(CurrentWeatherData body) {
        this.binding.iconWeather.setImageResource(AppUtils.getIconWeather(body.getWeather().get(0).getIcon()));
        this.binding.locationName.setText(body.getName());
        this.binding.weatherStatus.setText(body.getWeather().get(0).getDescription());

    }
}
