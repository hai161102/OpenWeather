package com.haiprj.apps.openweather.view.holder;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;

import com.haiprj.apps.openweather.App;
import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.api.result.Daily;
import com.haiprj.apps.openweather.base.BaseHolder;
import com.haiprj.apps.openweather.databinding.ItemDayInweekBinding;
import com.haiprj.apps.openweather.utils.AppUnits;
import com.haiprj.apps.openweather.utils.AppUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyHolder extends BaseHolder<ItemDayInweekBinding, Daily> {
    public DailyHolder(Context context, @NonNull ItemDayInweekBinding binding) {
        super(context, binding);
    }

    @SuppressLint({"SimpleDateFormat", "SetTextI18n", "DefaultLocale"})
    @Override
    public void load(Daily data) {
        this.binding.dayName.setText(new SimpleDateFormat("EE").format(new Date(data.getDate() * 1000)));
        this.binding.percent.setText(data.getPop() + "%");
        this.binding.maxTemp.setText(AppUnits.getInstance().getTemp(data.getTemp().getMax()));
        this.binding.minTemp.setText(AppUnits.getInstance().getTemp(data.getTemp().getMin()));
        int id = AppUtils.getIconWeather(data.getWeather().get(0).getIcon());
        if (id != -1)
            this.binding.iconWeather.setImageResource(id);
    }
}
