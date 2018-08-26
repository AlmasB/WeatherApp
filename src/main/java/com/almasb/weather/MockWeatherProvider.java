package com.almasb.weather;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class MockWeatherProvider implements WeatherSupplier {

    @Override
    public Weather get(String cityName) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Weather(cityName, 14.5);
    }
}
