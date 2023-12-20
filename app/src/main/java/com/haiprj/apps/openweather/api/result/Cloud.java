package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cloud implements Serializable {
    @SerializedName("all")
    private Float all;

    public Float getAll() {
        return all;
    }

    public void setAll(Float all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "Cloud{" +
                "all=" + all +
                '}';
    }
}
