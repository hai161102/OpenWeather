package com.haiprj.apps.openweather.view.activity;

import android.annotation.SuppressLint;
import android.os.Handler;

import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.base.BaseActivity;
import com.haiprj.apps.openweather.databinding.ActivitySplashBinding;
import com.haiprj.apps.openweather.utils.SharePreferenceUtil;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity<ActivitySplashBinding> {
    @Override
    protected void initView() {
        SharePreferenceUtil.getInstance().init(this);

        new Handler().postDelayed(() -> {
            SignActivity.start(SplashActivity.this);
            finish();
        }, 2000);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_splash;
    }
}
