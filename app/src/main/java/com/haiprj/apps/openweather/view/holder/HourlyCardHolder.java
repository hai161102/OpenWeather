package com.haiprj.apps.openweather.view.holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.haiprj.apps.openweather.api.result.Hourly;
import com.haiprj.apps.openweather.api.result.HourlyForecastResult;
import com.haiprj.apps.openweather.base.BaseHolder;
import com.haiprj.apps.openweather.databinding.ItemHourlyBinding;
import com.haiprj.apps.openweather.model.HourlyItem;
import com.haiprj.apps.openweather.utils.AppUnits;
import com.haiprj.apps.openweather.utils.AppUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HourlyCardHolder extends BaseHolder<ItemHourlyBinding, HourlyItem> {

    public HourlyCardHolder(Context context, @NonNull ItemHourlyBinding binding) {
        super(context, binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void load(HourlyItem data) {
        Date date = new Date(data.getHourly().getDate() * 1000);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        this.binding.hour.setText(simpleDateFormat.format(date));
        this.binding.temp.setText(AppUnits.getInstance().getTemp(data.getHourly().getCurrent().getTemp()));
        this.binding.iconWeather.setImageResource(AppUtils.getIconWeather(data.getHourly().getWeather().get(0).getIcon()));
        this.binding.percentRain.setText(data.getHourly().getPop() + "%");
        this.binding.status.setText(data.getHourly().getWeather().get(0).getDescription());
        this.binding.textDataWind.setText(getText(data.getHourly().getWind().getSpeed()) + "m/s");
        this.binding.textDataWindGust.setText(getText(data.getHourly().getWind().getGust()) + "m/s");
        this.binding.textDataHumidity.setText(getText(data.getHourly().getCurrent().getHumidity()) + "%");
        this.binding.textDataCloud.setText(getText(data.getHourly().getCloud().getAll()) + "%");
        this.binding.textDataPressure.setText(getText(data.getHourly().getCurrent().getPressure()) + "hPa");
        this.binding.textDataVisibility.setText(getText(data.getHourly().getVisibility()) + "m");
        this.binding.status.setOnClickListener(v -> {
            data.setExpand(!data.isExpand());
            getAdapter().notifyItemChanged(getAdapterPosition());
        });
        this.binding.expandView.setOnClickListener(v -> {
            data.setExpand(!data.isExpand());
            getAdapter().notifyItemChanged(getAdapterPosition());
        });

        if (data.isExpand()) {
            this.binding.iconExpand.setRotation(90);
            this.binding.addView.setVisibility(View.VISIBLE);
        }
        else {
            this.binding.iconExpand.setRotation(-90);
            this.binding.addView.setVisibility(View.GONE);
        }
    }

    private String getText(Object data) {
        return ": " + data;
    }

}
