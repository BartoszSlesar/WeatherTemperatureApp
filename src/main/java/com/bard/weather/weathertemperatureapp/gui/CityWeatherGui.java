package com.bard.weather.weathertemperatureapp.gui;


import com.bard.weather.weathertemperatureapp.model.CityWeather;
import com.bard.weather.weathertemperatureapp.services.WeatherApiService;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("temperatures")
public class CityWeatherGui extends HorizontalLayout {

    private final WeatherApiService weatherApiService;

    public CityWeatherGui(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
        CityWeather cityWeather = weatherApiService.getWeatherForCity("Katowice");
        TextField readonlyField = new TextField();
        readonlyField.setReadOnly(true);
        readonlyField.setLabel("Temperature");
        readonlyField.setValue(cityWeather.getCity() + " temperature " + cityWeather.getTemperature());
        add(readonlyField);
    }
}
