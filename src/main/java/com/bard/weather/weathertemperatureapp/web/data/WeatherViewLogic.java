package com.bard.weather.weathertemperatureapp.web.data;

import com.bard.weather.weathertemperatureapp.model.Weather;
import com.bard.weather.weathertemperatureapp.services.WeatherService;
import com.bard.weather.weathertemperatureapp.web.resultview.WeatherViewCard;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherViewLogic implements UpdateValueForFront {

    private final WeatherViewCard weatherView;
    private final WeatherService weatherService;

    public WeatherViewLogic(WeatherService weatherService, WeatherViewCard weatherView) {
        this.weatherView = weatherView;
        this.weatherService = weatherService;
    }

    @Override
    public void updateContent() {
        weatherView.getUI().ifPresent(ui -> ui.access(() -> {
            Weather weather = this.weatherService.getCityTemperature(weatherView.getTitle());
            this.weatherView.setTemperature("Condition: " + weather.getWeatherCondition());
            this.weatherView.setCondition("Temperature: " + weather.getTemperature() + "C");

        }));

        weatherView.getUI().ifPresent(ui -> ui.getPage().reload());


    }
}
