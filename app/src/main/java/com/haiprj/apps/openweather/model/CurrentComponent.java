package com.haiprj.apps.openweather.model;

public class CurrentComponent {
    private int resId;
    private String name;
    private String value;

    public CurrentComponent(int resId, String name, String value) {
        this.resId = resId;
        this.name = name;
        this.value = value;
    }

    public CurrentComponent() {
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
