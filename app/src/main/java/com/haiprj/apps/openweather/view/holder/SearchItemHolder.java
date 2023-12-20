package com.haiprj.apps.openweather.view.holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.haiprj.apps.openweather.api.ApiConfigs;
import com.haiprj.apps.openweather.api.result.CurrentWeatherData;
import com.haiprj.apps.openweather.api.result.Geo;
import com.haiprj.apps.openweather.base.BaseHolder;
import com.haiprj.apps.openweather.databinding.ItemSearchBinding;
import com.haiprj.apps.openweather.interfaces.OnSearchItemClick;
import com.haiprj.apps.openweather.utils.AppUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchItemHolder extends BaseHolder<ItemSearchBinding, Geo> {

    private OnSearchItemClick onSearchItemClick;

    public SearchItemHolder setOnSearchItemClick(OnSearchItemClick onSearchItemClick) {
        this.onSearchItemClick = onSearchItemClick;
        return this;
    }

    public SearchItemHolder(Context context, @NonNull ItemSearchBinding binding) {
        super(context, binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void load(Geo data) {
        binding.deleteBtn.setVisibility(View.GONE);
        ApiConfigs.getInstance().apiServices.getCurrentWeatherData(
                data.getLat(),
                data.getLon(),
                ApiConfigs.API_KEY,
                "vi"
        ).enqueue(new Callback<CurrentWeatherData>() {
            @Override
            public void onResponse(@NonNull Call<CurrentWeatherData> call, @NonNull Response<CurrentWeatherData> response) {
                if (response.isSuccessful() && response.body() != null) {
                    SearchItemHolder.this.binding.iconWeather.setImageResource(AppUtils.getIconWeather(
                            response.body().getWeather().get(0).getIcon()
                    ));
                    SearchItemHolder.this.binding.weatherStatus.setText(
                            response.body().getWeather().get(0).getDescription()
                    );
                    SearchItemHolder.this.binding.locationName.setText(
                            response.body().getName()
                    );
                }
            }

            @Override
            public void onFailure(@NonNull Call<CurrentWeatherData> call, @NonNull Throwable t) {
                Log.d("SearchItemHolder", "onFailure: " + t.getMessage());
            }
        });
        this.binding.getRoot().setOnClickListener(v -> {
            if (this.onSearchItemClick != null) {
                this.onSearchItemClick.onClick(data);
            }
        });
    }
}
