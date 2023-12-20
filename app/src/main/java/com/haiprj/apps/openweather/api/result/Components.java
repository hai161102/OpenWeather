package com.haiprj.apps.openweather.api.result;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Components implements Serializable {
    @SerializedName("no2")
    private Float no2;
    @SerializedName("no")
    private Float no;
    @SerializedName("o3")
    private Float o3;
    @SerializedName("so2")
    private Float so2;
    @SerializedName("pm2_5")
    private Float pm2_5;
    @SerializedName("pm10")
    private Float pm10;
    @SerializedName("nh3")
    private Float nh3;
    @SerializedName("co")
    private Float co;

    public Float getNo2() {
        return this.no2;
    }

    public void setNo2(Float no2) {
        this.no2 = no2;
    }

    public Float getNo() {
        return this.no;
    }

    public void setNo(Float no) {
        this.no = no;
    }

    public Float getO3() {
        return this.o3;
    }

    public void setO3(Float o3) {
        this.o3 = o3;
    }

    public Float getSo2() {
        return this.so2;
    }

    public void setSo2(Float so2) {
        this.so2 = so2;
    }

    public Float getPm2_5() {
        return this.pm2_5;
    }

    public void setPm2_5(Float pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public Float getPm10() {
        return this.pm10;
    }

    public void setPm10(Float pm10) {
        this.pm10 = pm10;
    }

    public Float getNh3() {
        return this.nh3;
    }

    public void setNh3(Float nh3) {
        this.nh3 = nh3;
    }

    public Float getCo() {
        return this.co;
    }

    public void setCo(Float co) {
        this.co = co;
    }
}