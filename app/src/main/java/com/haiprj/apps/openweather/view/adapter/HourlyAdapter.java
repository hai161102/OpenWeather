package com.haiprj.apps.openweather.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.api.result.Hourly;
import com.haiprj.apps.openweather.base.BaseAdapter;
import com.haiprj.apps.openweather.databinding.ItemHourMainBinding;
import com.haiprj.apps.openweather.view.holder.HourlyHolder;

public class HourlyAdapter extends BaseAdapter<Hourly, ItemHourMainBinding, HourlyHolder> {

    public HourlyAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_hour_main;
    }

    @NonNull
    @Override
    public HourlyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HourlyHolder(context, DataBindingUtil.inflate(LayoutInflater.from(this.context), getLayoutId(), parent, false));
    }
}
