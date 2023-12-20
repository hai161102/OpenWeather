package com.haiprj.apps.openweather.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.base.BaseAdapter;
import com.haiprj.apps.openweather.databinding.ItemSearchBinding;
import com.haiprj.apps.openweather.interfaces.OnFavoriteClickListener;
import com.haiprj.apps.openweather.model.Coordinate;
import com.haiprj.apps.openweather.model.CoordinateFavorite;
import com.haiprj.apps.openweather.view.holder.FavoriteHolder;

public class FavoriteAdapter extends BaseAdapter<CoordinateFavorite, ItemSearchBinding, FavoriteHolder> {

    private OnFavoriteClickListener listener;

    public void setListener(OnFavoriteClickListener listener) {
        this.listener = listener;
    }

    public FavoriteAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_search;
    }


    @NonNull
    @Override
    public FavoriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoriteHolder(
                this.context,
                DataBindingUtil.inflate(
                        LayoutInflater.from(this.context),
                        this.getLayoutId(),
                        parent,
                        false
                )
        ).setListener(coordinate -> {
            if (listener != null) {
                listener.onClick(coordinate);
            }
        });
    }
}
