package com.haiprj.apps.openweather.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.base.BaseAdapter;
import com.haiprj.apps.openweather.databinding.ItemWeatherComponentsBinding;
import com.haiprj.apps.openweather.model.CurrentComponent;
import com.haiprj.apps.openweather.view.holder.CurrentComponentHolder;

public class CurrentComponentAdapter extends BaseAdapter<CurrentComponent, ItemWeatherComponentsBinding, CurrentComponentHolder> {
    public CurrentComponentAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_weather_components;
    }


    @NonNull
    @Override
    public CurrentComponentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CurrentComponentHolder(this.context, DataBindingUtil.inflate(LayoutInflater.from(this.context), getLayoutId(), parent, false));
    }
}
