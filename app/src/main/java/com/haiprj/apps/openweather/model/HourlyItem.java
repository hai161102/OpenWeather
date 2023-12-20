package com.haiprj.apps.openweather.model;

import com.haiprj.apps.openweather.api.result.Hourly;

public class HourlyItem {
    private Hourly hourly;
    private boolean isExpand = false;

    public HourlyItem(Hourly hourly, boolean isExpand) {
        this.hourly = hourly;
        this.isExpand = isExpand;
    }

    public HourlyItem() {
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }
}
