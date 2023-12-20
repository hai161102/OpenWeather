package com.haiprj.apps.openweather.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.api.result.Hourly;
import com.haiprj.apps.openweather.base.BaseAdapter;
import com.haiprj.apps.openweather.databinding.ItemHourlyBinding;
import com.haiprj.apps.openweather.model.HourlyItem;
import com.haiprj.apps.openweather.view.holder.HourlyCardHolder;

public class HourlyCardAdapter extends BaseAdapter<HourlyItem, ItemHourlyBinding, HourlyCardHolder> {
    public HourlyCardAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_hourly;
    }

    @NonNull
    @Override
    public HourlyCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return (HourlyCardHolder) new HourlyCardHolder(
                this.context,
                DataBindingUtil.inflate(
                        LayoutInflater.from(this.context),
                        getLayoutId(),
                        parent, false
                )
        );
    }
}
