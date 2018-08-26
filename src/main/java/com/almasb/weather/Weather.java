package com.almasb.weather;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public final class Weather {

    private String cityName;
    private double temp;

    public Weather(String cityName, double temp) {
        this.cityName = cityName;
        this.temp = temp;
    }

    public String getCityName() {
        return cityName;
    }

    public double getTemp() {
        return temp;
    }
}
