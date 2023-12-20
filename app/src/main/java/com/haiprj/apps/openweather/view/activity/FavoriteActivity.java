package com.haiprj.apps.openweather.view.activity;

import android.content.Intent;

import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.api.result.Coord;
import com.haiprj.apps.openweather.base.BaseActivity;
import com.haiprj.apps.openweather.databinding.ActivityFavoriteLocationBinding;
import com.haiprj.apps.openweather.interfaces.OnFavoriteClickListener;
import com.haiprj.apps.openweather.model.Coordinate;
import com.haiprj.apps.openweather.room.AppDatabase;
import com.haiprj.apps.openweather.view.adapter.FavoriteAdapter;

public class FavoriteActivity extends BaseActivity<ActivityFavoriteLocationBinding> {

    public final static String ONCLICK_FAVORITE = "ONCLICK_FAVORITE";
    private FavoriteAdapter adapter;
    @Override
    protected void initView() {
        this.binding.header.title.setText(R.string.fav_loc);
        adapter = new FavoriteAdapter(this);
        binding.rcvFavorite.setAdapter(adapter);
        adapter.addMulti(AppDatabase.getInstance().dataCoordinateFavorite().getAll(), true);
    }

    @Override
    protected void initData() {
        this.binding.header.back.setOnClickListener(v-> {
            this.finish();
        });
        this.adapter.setListener(coordinate -> {
            Coord coord = new Coord();
            coord.setLat(coordinate.getLat());
            coord.setLon(coordinate.getLon());
            Intent intent = new Intent();
            intent.putExtra(ONCLICK_FAVORITE, coord);
            this.setResult(RESULT_OK, intent);
            this.finish();
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_favorite_location;
    }
}
