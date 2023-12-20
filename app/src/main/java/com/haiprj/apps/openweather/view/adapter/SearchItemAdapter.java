package com.haiprj.apps.openweather.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.api.result.Geo;
import com.haiprj.apps.openweather.base.BaseAdapter;
import com.haiprj.apps.openweather.databinding.ItemSearchBinding;
import com.haiprj.apps.openweather.interfaces.OnSearchItemClick;
import com.haiprj.apps.openweather.view.holder.SearchItemHolder;

public class SearchItemAdapter extends BaseAdapter<Geo, ItemSearchBinding, SearchItemHolder> {

    private OnSearchItemClick onSearchItemClick;

    public void setOnSearchItemClick(OnSearchItemClick onSearchItemClick) {
        this.onSearchItemClick = onSearchItemClick;
    }

    public SearchItemAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_search;
    }

    @NonNull
    @Override
    public SearchItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchItemHolder(this.context, DataBindingUtil.inflate(LayoutInflater.from(this.context)
                ,getLayoutId(), parent, false)).setOnSearchItemClick(geo -> {
                    if (this.onSearchItemClick != null) {
                        this.onSearchItemClick.onClick(geo);
                    }
                });
    }


}
