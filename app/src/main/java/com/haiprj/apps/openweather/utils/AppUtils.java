package com.haiprj.apps.openweather.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.core.app.ActivityCompat;

import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.api.result.Geo;
import com.haiprj.apps.openweather.base.BaseActivity;
import com.haiprj.apps.openweather.model.GeoData;

import java.util.ArrayList;
import java.util.List;

public class AppUtils {

    public static List<String> requestPermission(BaseActivity<?> context, int requestCode) {
        List<String> list = new ArrayList<>();
        if (!isGranted(context, android.Manifest.permission.ACCESS_FINE_LOCATION)
                || !isGranted(context, Manifest.permission.ACCESS_COARSE_LOCATION)) {
            List<String> permissions = new ArrayList<>();
            if (!isGranted(context, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                permissions.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
            }
            else {
                list.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if (!isGranted(context, Manifest.permission.ACCESS_COARSE_LOCATION))
            {
                permissions.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            else {
                list.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            String[] pms = new String[permissions.size()];
            for (int i = 0; i < permissions.size(); i++) {
                pms[i] = permissions.get(i);
            }

            ActivityCompat.requestPermissions(context, pms, requestCode);
            return list;
        }
        list.add(Manifest.permission.ACCESS_FINE_LOCATION);
        list.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        return list;
    }
    public static Geo getGeoFromGeoData(GeoData data) {
        Geo geo = new Geo();
        geo.setCountry(data.getCountry());
        geo.setName(data.getName());
        geo.setLon(data.getLon());
        geo.setState(data.getState());
        geo.setLat(data.getLat());
        return geo;
    }

    public static List<Geo> convertDataToGeo(List<GeoData> data) {

        List<Geo> geos = new ArrayList<>();
        for (GeoData datum : data) {
            geos.add(getGeoFromGeoData(datum));
        }
        return geos;
    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean isGranted(Context context, String permission) {
        return ActivityCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_GRANTED;
    }
    public static float convertTempC(float f) {
        return (f - 32) * 5 / 9f;
    }
    public static float convertTempF(float c) { return c * 9 / 5 + 32; }
    public static float convertTempK(float K) {
        return K - 273.15f;
    }

    public static int getIconWeather(String id) {
        if (id.contains("d")) {
            switch (id) {
                case "01d":
                    return R.drawable.clear_sunny;
                case "02d":
                    return R.drawable.sun_cloudy;
                case "03d":
                case "04d":
                    return R.drawable.mostly_cloudy;
                case "10d":
                    return R.drawable.sun_rain;
                case "09d":
                    return R.drawable.rain;
                case "11d":
                    return R.drawable.thunder;
                case "13d":
                    return R.drawable.snow;
                case "50d":
                    return R.drawable.fog;
                default:
                    return -1;
            }
        }
        else {
            switch (id) {
                case "01n":
                    return R.drawable.moon;
                case "02n":
                    return R.drawable.cloudy_moon;
                case "03n":
                case "04n":
                    return R.drawable.mostly_cloudy;
                case "10n":
                case "09n":
                    return R.drawable.rain;
                case "11n":
                    return R.drawable.thunder;
                case "13n":
                    return R.drawable.snow;
                case "50n":
                    return R.drawable.fog;
                default:
                    return -1;
            }
        }

    }
}
