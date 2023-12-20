package com.haiprj.apps.openweather.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.base.BaseAdapter;
import com.haiprj.apps.openweather.databinding.ItemAirPollutionBinding;
import com.haiprj.apps.openweather.model.ItemAir;
import com.haiprj.apps.openweather.view.holder.AirPollutionHolder;

public class AirPollutionAdapter extends BaseAdapter<ItemAir, ItemAirPollutionBinding, AirPollutionHolder> {
    public AirPollutionAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_air_pollution;
    }

    @NonNull
    @Override
    public AirPollutionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AirPollutionHolder(this.context, DataBindingUtil.inflate(LayoutInflater.from(this.context), getLayoutId(), parent, false));
    }
}
