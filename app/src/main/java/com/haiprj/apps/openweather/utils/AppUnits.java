package com.haiprj.apps.openweather.utils;

import android.annotation.SuppressLint;
import android.content.Context;

import com.haiprj.apps.openweather.Const;
import com.haiprj.apps.openweather.R;

public class AppUnits {
    private static AppUnits instance;
    private Context context;

    public static AppUnits getInstance() {
        if (instance == null) instance = new AppUnits();
        return instance;
    }

    public void init(Context context) {
        this.context = context;
    }

    @SuppressLint("DefaultLocale")
    public String getTemp(float temp) {
        temp = AppUtils.convertTempK(temp);
        boolean c = SharePreferenceUtil.getInstance().getSharedPreferences().getBoolean(Const.TEMP_UNIT_KEY, true);
        String result =
                String.format("%.0f", temp)  + this.context.getString(R.string.icon_temp);
        if (!c) {
            temp = AppUtils.convertTempF(temp);
            result = String.format("%.0f", temp) + "F";
        }

        return result;
    }
}
