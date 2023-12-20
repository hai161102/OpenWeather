package com.haiprj.apps.openweather;

import android.app.Application;

import com.google.firebase.auth.FirebaseUser;
import com.haiprj.apps.openweather.api.ApiConfigs;
import com.haiprj.apps.openweather.room.AppDatabase;
import com.haiprj.apps.openweather.utils.AppUnits;
import com.haiprj.apps.openweather.utils.SharePreferenceUtil;

public class App extends Application {
    private static App instance;

    public static App getInstance() {
        return instance;
    }

    private FirebaseUser firebaseUser;

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    public void setFirebaseUser(FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        App.instance = this;
        ApiConfigs.getInstance();
        AppDatabase.getInstance(getApplicationContext());
        AppUnits.getInstance().init(getApplicationContext());
    }
}
