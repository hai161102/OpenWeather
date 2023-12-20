package com.haiprj.apps.openweather.view.holder;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;

import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.api.result.Hourly;
import com.haiprj.apps.openweather.base.BaseHolder;
import com.haiprj.apps.openweather.databinding.ItemHourMainBinding;
import com.haiprj.apps.openweather.utils.AppUnits;
import com.haiprj.apps.openweather.utils.AppUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HourlyHolder extends BaseHolder<ItemHourMainBinding, Hourly> {


    public HourlyHolder(Context context, @NonNull ItemHourMainBinding binding) {
        super(context, binding);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void load(Hourly data) {
        binding.temp.setText(AppUnits.getInstance().getTemp(data.getCurrent().getTemp()));
        binding.percent.setText(data.getPop() + "%");
        Date date = new Date(data.getDate() * 1000);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        binding.timeText.setText(simpleDateFormat.format(date));
        int id = AppUtils.getIconWeather(data.getWeather().get(0).getIcon());
        if (id != -1)
            binding.imageIcon.setImageResource(id);
    }
}
