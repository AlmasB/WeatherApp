package com.almasb.weather;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public interface WeatherSupplier {

    Weather get(String cityName);
}
