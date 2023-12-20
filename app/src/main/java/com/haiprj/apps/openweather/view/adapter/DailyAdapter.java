package com.haiprj.apps.openweather.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.api.result.Daily;
import com.haiprj.apps.openweather.base.BaseAdapter;
import com.haiprj.apps.openweather.databinding.ItemDayInweekBinding;
import com.haiprj.apps.openweather.view.holder.DailyHolder;

public class DailyAdapter extends BaseAdapter<Daily, ItemDayInweekBinding, DailyHolder> {
    public DailyAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_day_inweek;
    }

    @NonNull
    @Override
    public DailyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DailyHolder(this.context, DataBindingUtil.inflate(LayoutInflater.from(this.context), getLayoutId(), parent, false));
    }
}
