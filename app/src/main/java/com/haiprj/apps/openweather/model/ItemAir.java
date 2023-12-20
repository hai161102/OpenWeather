package com.haiprj.apps.openweather.model;

public class ItemAir {
    private String name;
    private float value;

    public ItemAir(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public ItemAir() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
