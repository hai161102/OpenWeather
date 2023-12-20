package com.haiprj.apps.openweather.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {
    protected T binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.inflate(LayoutInflater.from(this), this.getLayoutID(), null, false);
        this.setContentView(this.binding.getRoot());
        this.initView();
        this.initData();
    }

    protected abstract void initView();
    protected abstract void initData();
    protected abstract int getLayoutID();

    public T getBinding() {
        return binding;
    }
}
