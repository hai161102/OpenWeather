package com.haiprj.apps.openweather.view.holder;

import android.content.Context;

import androidx.annotation.NonNull;

import com.haiprj.apps.openweather.base.BaseHolder;
import com.haiprj.apps.openweather.databinding.ItemAirPollutionBinding;
import com.haiprj.apps.openweather.model.ItemAir;

public class AirPollutionHolder extends BaseHolder<ItemAirPollutionBinding, ItemAir> {
    public AirPollutionHolder(Context context, @NonNull ItemAirPollutionBinding binding) {
        super(context, binding);
    }

    @Override
    public void load(ItemAir data) {
        this.binding.name.setText(data.getName());
        this.binding.number.setText(String.valueOf(data.getValue()));
    }
}
