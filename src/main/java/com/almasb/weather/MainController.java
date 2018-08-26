package com.almasb.weather;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class MainController {

    @FXML
    private TextField fieldSearch;

    @FXML
    private Label labelInfo;

    private WeatherSupplier weatherSupplier;

    private WeatherService service = new WeatherService();

    public MainController(WeatherSupplier supplier) {
        weatherSupplier = supplier;
    }

    public void onSearch() {
        service.cityName = fieldSearch.getText();
        service.restart();
    }

    private class WeatherService extends Service<Weather> {

        private String cityName;

        @Override
        protected Task<Weather> createTask() {
            return new Task<Weather>() {
                @Override
                protected Weather call() throws Exception {
                    return weatherSupplier.get(cityName);
                }

                @Override
                protected void succeeded() {
                    Weather weather = getValue();

                    labelInfo.setText(weather.getCityName() + ": " + weather.getTemp());
                }

                @Override
                protected void failed() {
                    Throwable error = getException();

                    labelInfo.setText("Error: " + error);
                }
            };
        }
    }
}
