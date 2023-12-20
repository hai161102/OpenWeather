package com.haiprj.apps.openweather.view.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.api.ApiConfigs;
import com.haiprj.apps.openweather.api.result.Coord;
import com.haiprj.apps.openweather.api.result.Hourly;
import com.haiprj.apps.openweather.api.result.HourlyForecastResult;
import com.haiprj.apps.openweather.base.BaseActivity;
import com.haiprj.apps.openweather.databinding.ActivityHourlyBinding;
import com.haiprj.apps.openweather.model.HourlyItem;
import com.haiprj.apps.openweather.view.adapter.HourlyCardAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HourlyActivity extends BaseActivity<ActivityHourlyBinding> {

    public final static String COORD_KEY = "COORD_KEY";
    public static void start(Context context, Coord coord) {
        Intent starter = new Intent(context, HourlyActivity.class);
        starter.putExtra(COORD_KEY, coord);
        context.startActivity(starter);
    }

    protected HourlyCardAdapter adapter;
    @Override
    protected void initView() {

        adapter = new HourlyCardAdapter(this);
        this.binding.header.title.setText(R.string.hourly);
        this.binding.hourRcv.setAdapter(adapter);
        Coord coord = (Coord) this.getIntent().getSerializableExtra(COORD_KEY);
        if (coord != null) {
            ApiConfigs.getInstance().apiServices.getHourlyForecast(
                    coord.getLat(),
                    coord.getLon(),
                    ApiConfigs.API_KEY,
                    24,
                    "vi"
            ).enqueue(new Callback<HourlyForecastResult>() {
                @Override
                public void onResponse(@NonNull Call<HourlyForecastResult> call, @NonNull Response<HourlyForecastResult> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        List<HourlyItem> list = new ArrayList<>();
                        for (Hourly hourly : response.body().getList()) {
                            list.add(new HourlyItem(
                                    hourly,
                                    false
                            ));
                        }
                        adapter.addMulti(list, true);

                    }
                }

                @Override
                public void onFailure(@NonNull Call<HourlyForecastResult> call, @NonNull Throwable t) {
                    Toast.makeText(HourlyActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    protected void initData() {
        this.binding.header.back.setOnClickListener(v -> {
            this.finish();
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_hourly;
    }
}
