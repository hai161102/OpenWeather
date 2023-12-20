package com.haiprj.apps.openweather.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class SharePreferenceUtil {

    @SuppressLint("StaticFieldLeak")
    private static SharePreferenceUtil instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Activity context;

    public static SharePreferenceUtil getInstance() {
        if (SharePreferenceUtil.instance == null)
            SharePreferenceUtil.instance = new SharePreferenceUtil();
        return SharePreferenceUtil.instance;
    }

    private SharePreferenceUtil() {
    }

    public void init(Activity context) {
        this.context = context;
        this.sharedPreferences = context.getPreferences(Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    @SuppressWarnings("unchecked")
    public <T> void put(String key, T data) {
        if (!(data instanceof String)
                && !(data instanceof Integer)
                && !(data instanceof Long)
                && !(data instanceof Boolean)
                && !(data instanceof Float)
                && !(data instanceof Set)
        ) return;
        if (data instanceof String) getEditor().putString(key, (String) data);
        if (data instanceof Integer) getEditor().putInt(key, (Integer) data);
        if (data instanceof Long) getEditor().putLong(key, (Long) data);
        if (data instanceof Boolean) getEditor().putBoolean(key, (Boolean) data);
        if (data instanceof Float) getEditor().putFloat(key, (Float) data);
        if (data instanceof Set) getEditor().putStringSet(key, (Set<String>) data);
        getEditor().commit();
        getEditor().apply();
    }

}
