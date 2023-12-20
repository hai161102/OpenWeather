package com.haiprj.apps.openweather.view.fragment;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;

import androidx.annotation.NonNull;

import com.haiprj.apps.openweather.Const;
import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.api.ApiConfigs;
import com.haiprj.apps.openweather.api.result.AirPollution;
import com.haiprj.apps.openweather.api.result.Coord;
import com.haiprj.apps.openweather.api.result.CurrentWeatherData;
import com.haiprj.apps.openweather.api.result.Daily;
import com.haiprj.apps.openweather.api.result.DailyForecastResult;
import com.haiprj.apps.openweather.api.result.HourlyForecastResult;
import com.haiprj.apps.openweather.base.BaseActivity;
import com.haiprj.apps.openweather.base.BaseFragment;
import com.haiprj.apps.openweather.databinding.FragmentMainWeatherBinding;
import com.haiprj.apps.openweather.model.CurrentComponent;
import com.haiprj.apps.openweather.model.ItemAir;
import com.haiprj.apps.openweather.utils.AppUnits;
import com.haiprj.apps.openweather.utils.AppUtils;
import com.haiprj.apps.openweather.utils.SharePreferenceUtil;
import com.haiprj.apps.openweather.view.activity.HourlyActivity;
import com.haiprj.apps.openweather.view.adapter.AirPollutionAdapter;
import com.haiprj.apps.openweather.view.adapter.DailyAdapter;
import com.haiprj.apps.openweather.view.adapter.CurrentComponentAdapter;
import com.haiprj.apps.openweather.view.adapter.HourlyAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainWeatherFragment extends BaseFragment<FragmentMainWeatherBinding> {
    private final Coord coord;
    private boolean isTempC = true;
    private CurrentWeatherData currentWeatherData;
    private DailyForecastResult dailyForecastResult;
    private HourlyForecastResult hourlyForecastResult;
    private AirPollution airPollution;
    private HourlyAdapter hourlyAdapter;
    private DailyAdapter dailyAdapter;
    private AirPollutionAdapter airPollutionAdapter;
    private CurrentComponentAdapter currentComponentAdapter;
    private OnLoadDone onLoadDone;

    public Coord getCoord() {
        return coord;
    }

    public void setOnLoadDone(OnLoadDone onLoadDone) {
        this.onLoadDone = onLoadDone;
    }

    public boolean isTempC() {
        return isTempC;
    }

    public void setTempC(boolean tempC) {
        isTempC = tempC;
    }

    public MainWeatherFragment(BaseActivity<?> parent, Coord coord) {
        super(parent);
        this.coord = coord;
        this.isTempC = SharePreferenceUtil.getInstance().getSharedPreferences().getBoolean(Const.TEMP_UNIT_KEY, true);
    }

    @Override
    protected void initView() {
        this.hourlyAdapter = new HourlyAdapter(this.getContext());
        this.binding.rcv24h.setAdapter(hourlyAdapter);
        this.dailyAdapter = new DailyAdapter(this.getContext());
        this.binding.rcvWeek.setAdapter(dailyAdapter);
        this.airPollutionAdapter = new AirPollutionAdapter(this.getContext());
        this.binding.rcvAirQuality.setAdapter(this.airPollutionAdapter);
        this.currentComponentAdapter = new CurrentComponentAdapter(this.getContext());
        this.binding.rcvComponents.setAdapter(currentComponentAdapter);
        this.loadCurrentWeather();

        this.loadDailyForecast();
        this.loadHourlyForecast();
        this.loadAqi();
    }

    private void loadAqi() {
        ApiConfigs.getInstance().apiServices.getCurrentAQI(
                this.coord.getLat(),
                this.coord.getLon(),
                ApiConfigs.API_KEY
        ).enqueue(new Callback<AirPollution>() {
            @Override
            public void onResponse(@NonNull Call<AirPollution> call, @NonNull Response<AirPollution> response) {
                if (response.isSuccessful() && response.body() != null && MainWeatherFragment.this.getContext() != null) {
                    MainWeatherFragment.this.airPollution = response.body();
                    MainWeatherFragment.this.reloadAirPollution();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AirPollution> call, @NonNull Throwable t) {

            }
        });
    }

    private void loadHourlyForecast() {
        ApiConfigs.getInstance().apiServices.getHourlyForecast(
                this.coord.getLat(),
                this.coord.getLon(),
                ApiConfigs.API_KEY,
                24,
                "vi"
        ).enqueue(new Callback<HourlyForecastResult>() {
            @Override
            public void onResponse(@NonNull Call<HourlyForecastResult> call, @NonNull Response<HourlyForecastResult> response) {
                Log.d("TAG-Log-Query", "getHourlyForecast: " + response);
                if (response.isSuccessful() && response.body() != null && MainWeatherFragment.this.getContext() != null) {
                    MainWeatherFragment.this.hourlyForecastResult = response.body();
                    MainWeatherFragment.this.reloadHourly();
                    if (onLoadDone != null) onLoadDone.onDoneHourly(hourlyForecastResult);
                }
            }

            @Override
            public void onFailure(@NonNull Call<HourlyForecastResult> call, @NonNull Throwable t) {

            }
        });
    }

    private void loadDailyForecast() {
        ApiConfigs.getInstance().apiServices.getDailyForecast(
                this.coord.getLat(),
                this.coord.getLon(),
                ApiConfigs.API_KEY,
                7,
                "vi"
        ).enqueue(new Callback<DailyForecastResult>() {
            @Override
            public void onResponse(@NonNull Call<DailyForecastResult> call, @NonNull Response<DailyForecastResult> response) {
                if (response.isSuccessful() && response.body() != null && MainWeatherFragment.this.getContext() != null) {
                    MainWeatherFragment.this.dailyForecastResult = response.body();
                    MainWeatherFragment.this.reloadDaily();
                    if (onLoadDone != null) onLoadDone.onDoneDaily(dailyForecastResult);
                }
            }

            @Override
            public void onFailure(@NonNull Call<DailyForecastResult> call, @NonNull Throwable t) {

            }
        });
    }

    private void loadCurrentWeather() {
        ApiConfigs.getInstance().apiServices.getCurrentWeatherData(
                this.coord.getLat(),
                this.coord.getLon(),
                ApiConfigs.API_KEY,
                "vi"
        ).enqueue(new Callback<CurrentWeatherData>() {
            @Override
            public void onResponse(@NonNull Call<CurrentWeatherData> call, @NonNull Response<CurrentWeatherData> response) {
                Log.d("TAG-Log-Query", "getCurrentWeatherData: " + response);
                if (response.isSuccessful() && response.body() != null && MainWeatherFragment.this.getContext() != null) {
                    MainWeatherFragment.this.currentWeatherData = response.body();
                    MainWeatherFragment.this.reloadCurrentWeather();
                    if (onLoadDone != null) onLoadDone.onDoneCurrent(currentWeatherData);
                }
            }

            @Override
            public void onFailure(@NonNull Call<CurrentWeatherData> call, @NonNull Throwable t) {

            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void reloadAirPollution() {
        List<ItemAir> itemAirList = new ArrayList<>();
        itemAirList.add(new ItemAir("PM2.5", airPollution.getList().get(0).getComponents().getPm2_5()));
        itemAirList.add(new ItemAir("PM10", airPollution.getList().get(0).getComponents().getPm10()));
        itemAirList.add(new ItemAir("NO2", airPollution.getList().get(0).getComponents().getNo2()));
        itemAirList.add(new ItemAir("03", airPollution.getList().get(0).getComponents().getNh3()));
        itemAirList.add(new ItemAir("SO2", airPollution.getList().get(0).getComponents().getSo2()));
        itemAirList.add(new ItemAir("NO", airPollution.getList().get(0).getComponents().getNo()));
        itemAirList.add(new ItemAir("CO", airPollution.getList().get(0).getComponents().getCo()));
        this.airPollutionAdapter.addMulti(itemAirList, true);
        float currentAqi = airPollution.getList().get(0).getAqi().getAqi();
        ColorStateList colorStateList;
        if (currentAqi >= 0 && currentAqi < 50) {
            colorStateList = ColorStateList.valueOf(Color.parseColor("#61E075"));
        } else if (currentAqi >= 50 && currentAqi < 100) {
            colorStateList = ColorStateList.valueOf(Color.parseColor("#FFC100"));
        } else if (currentAqi >= 101 && currentAqi < 150) {
            colorStateList = ColorStateList.valueOf(Color.parseColor("#FF7C43"));
        } else {
            colorStateList = ColorStateList.valueOf(Color.parseColor("#EA5636"));
        }
        this.binding.aqi.setText("AQI: " + currentAqi);
        this.binding.aqi.setBackgroundTintList(colorStateList);
    }

    private void reloadHourly() {
        this.hourlyAdapter.addMulti(this.hourlyForecastResult.getList(), true);

    }

    private void reloadDaily() {
        this.dailyAdapter.addMulti(this.dailyForecastResult.getDailyList(), true);
        Daily daily = dailyForecastResult.getDailyList().get(0);

    }

    @SuppressWarnings("ConstantConditions")
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void reloadCurrentWeather() {
        this.binding.feelsLike.setText(getContext().getString(R.string.feels_like) + ": "
                + AppUnits.getInstance().getTemp(currentWeatherData.getCurrent().getFeelsLike()));
        this.binding.weatherState.setText(currentWeatherData.getWeather().get(0).getDescription());
        this.binding.maxTemp.setText(AppUnits.getInstance().getTemp(currentWeatherData.getCurrent().getTempMax()));
        this.binding.minTemp.setText(AppUnits.getInstance().getTemp(currentWeatherData.getCurrent().getTempMin()));
        this.binding.temp.setText(AppUnits.getInstance().getTemp(currentWeatherData.getCurrent().getTemp()));
        List<CurrentComponent> currentComponents = new ArrayList<>();
        currentComponents.add(
                new CurrentComponent(
                        R.drawable.ic_temperature,
                        getContext().getString(R.string.feels_like),
                        AppUnits.getInstance().getTemp(currentWeatherData.getCurrent().getFeelsLike())
                )
        );
        if (currentWeatherData.getRain() != null) {
            Log.d("TAG-Log-Query", "reloadCurrentWeather: " + currentWeatherData.getRain().getOneHour() + ", " + currentWeatherData.getRain().getThreeHours());
            currentComponents.add(
                    new CurrentComponent(
                            R.drawable.ic_rain,
                            getContext().getString(R.string.chance_of_rain),
                            currentWeatherData.getRain().getOneHour() + "%"
                    )
            );
        }
        currentComponents.add(
                new CurrentComponent(
                        R.drawable.ic_windspeed,
                        getContext().getString(R.string.wind_speed),
                        currentWeatherData.getWind().getSpeed() + "m/s"
                )
        );
        currentComponents.add(
                new CurrentComponent(
                        R.drawable.ic_visibility,
                        getContext().getString(R.string.visibility),
                        String.format("%.2f", currentWeatherData.getVisibility() / 1000f) + "km"
                )
        );
        currentComponents.add(
                new CurrentComponent(
                        R.drawable.ic_humidity,
                        getContext().getString(R.string.humidity),
                        currentWeatherData.getCurrent().getHumidity() + "%"
                )
        );
        currentComponents.add(
                new CurrentComponent(
                        R.drawable.ic_pressure,
                        getContext().getString(R.string.pressure),
                        currentWeatherData.getCurrent().getSeaLevel() + "hPa"
                )
        );
//        currentComponents.add(
//                new CurrentComponent(
//                        R.drawable.ic_uv,
//                        "UV index",
//                        currentWeatherData.getCurrent().getFeelsLike() + ""
//                )
//        );
//        currentComponents.add(
//                new CurrentComponent(
//                        R.drawable.precipitation,
//                        "Precipitation",
//                        currentWeatherData.getCurrent().getFeelsLike() + getContext().getString(R.string.icon_temp)
//                )
//        );
        currentComponentAdapter.addMulti(currentComponents, true);
        int resId = AppUtils.getIconWeather(currentWeatherData.getWeather().get(0).getIcon());
        if (resId != -1) {
            this.binding.iconWeather.setImageResource(resId);
        }
    }

    @Override
    protected void initEvent() {
        this.binding.details24h.setOnClickListener(v -> {
            HourlyActivity.start(this.getContext(), this.getCoord());
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_weather;
    }

    public CurrentWeatherData getCurrentWeatherData() {
        return currentWeatherData;
    }

    public void reloadData() {
        loadCurrentWeather();
        loadDailyForecast();
        loadHourlyForecast();
        loadAqi();
    }

    public interface OnLoadDone {
        default void onDoneCurrent(CurrentWeatherData currentWeatherData) {
        }

        default void onDoneDaily(DailyForecastResult dailyForecastResult) {
        }

        default void onDoneHourly(HourlyForecastResult hourlyForecastResult) {
        }
    }

}
