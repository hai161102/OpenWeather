package com.haiprj.apps.openweather.view.holder;


import android.content.Context;

import androidx.annotation.NonNull;

import com.haiprj.apps.openweather.base.BaseHolder;
import com.haiprj.apps.openweather.databinding.ItemWeatherComponentsBinding;
import com.haiprj.apps.openweather.model.CurrentComponent;

public class CurrentComponentHolder extends BaseHolder<ItemWeatherComponentsBinding, CurrentComponent> {
    public CurrentComponentHolder(Context context, @NonNull ItemWeatherComponentsBinding binding) {
        super(context, binding);
    }

    @Override
    public void load(CurrentComponent data) {
        this.binding.icon.setImageResource(data.getResId());
        this.binding.name.setText(data.getName());
        this.binding.value.setText(data.getValue());
    }
}
