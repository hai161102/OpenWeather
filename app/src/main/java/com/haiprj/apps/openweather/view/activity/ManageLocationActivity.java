package com.haiprj.apps.openweather.view.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.haiprj.apps.openweather.App;
import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.api.ApiConfigs;
import com.haiprj.apps.openweather.api.result.Coord;
import com.haiprj.apps.openweather.api.result.Geo;
import com.haiprj.apps.openweather.base.BaseActivity;
import com.haiprj.apps.openweather.databinding.ActivityManageLocationBinding;
import com.haiprj.apps.openweather.interfaces.OnSearchItemClick;
import com.haiprj.apps.openweather.model.Coordinate;
import com.haiprj.apps.openweather.model.GeoData;
import com.haiprj.apps.openweather.room.AppDatabase;
import com.haiprj.apps.openweather.utils.AppUtils;
import com.haiprj.apps.openweather.view.adapter.SearchItemAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageLocationActivity extends BaseActivity<ActivityManageLocationBinding> {

    public final static String SEARCH_RESULT = "SEARCH_RESULT";
    private SearchItemAdapter searchItemAdapter;
    @Override
    protected void initView() {
        this.searchItemAdapter = new SearchItemAdapter(this);
        binding.header.title.setText(getString(R.string.manage_location));
        this.binding.rcvListSearch.setAdapter(this.searchItemAdapter);
        loadListSearched();
    }

    @Override
    protected void initData() {
        this.searchItemAdapter.setOnSearchItemClick(geo -> {
            Coordinate coordinate = new Coordinate();
            coordinate.setLat(geo.getLat());
            coordinate.setLon(geo.getLon());
            boolean isExits = false;
            for (Coordinate coordinate1 : AppDatabase.getInstance().dataCoordinate().getAll()) {
                if (coordinate1.getLat().equals(geo.getLat())
                && coordinate1.getLon().equals(geo.getLon())) {
                    isExits = true;
                    break;
                }
            }
            if (!isExits) {
                AppDatabase.getInstance().dataCoordinate().insert(coordinate);
                AppDatabase.getInstance().dataSearch().add(new GeoData().set(geo));
            }

            Intent intent = new Intent();
            Coord coord = new Coord();
            coord.setLat(geo.getLat());
            coord.setLon(geo.getLon());
            intent.putExtra(SEARCH_RESULT, coord);
            this.setResult(RESULT_OK, intent);
            this.finish();
        });
        binding.header.back.setOnClickListener(v -> {
            this.finish();
        });
        binding.searchContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.next.setVisibility((s.length() > 0) ? View.VISIBLE : View.GONE);
                if (s.length() <= 0) loadListSearched();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.searchContent.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search();
                }
                return false;
            }
        });
        binding.next.setOnClickListener(v -> {
            this.search();
        });

    }

    private void search() {
        AppUtils.hideKeyboard(ManageLocationActivity.this);
        ApiConfigs.getInstance()
                .apiServices
                .getLocations(binding.searchContent.getText().toString(), 10, ApiConfigs.API_KEY)
                .enqueue(new Callback<List<Geo>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Geo>> call, @NonNull Response<List<Geo>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            searchItemAdapter.addMulti(response.body(), true);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Geo>> call, @NonNull Throwable t) {

                    }
                });
    }

    private void loadListSearched() {
        searchItemAdapter.addMulti(
                AppUtils.convertDataToGeo(AppDatabase.getInstance().dataSearch().gets()), true);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_manage_location;
    }
}
