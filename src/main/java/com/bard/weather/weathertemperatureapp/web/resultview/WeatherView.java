package com.bard.weather.weathertemperatureapp.web.resultview;

import com.bard.weather.weathertemperatureapp.model.Weather;
import com.bard.weather.weathertemperatureapp.services.WeatherService;
import com.bard.weather.weathertemperatureapp.web.data.WeatherViewLogic;
import com.bard.weather.weathertemperatureapp.web.resultview.WeatherViewCard;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WeatherView extends FlexLayout {

    private String city;
    private String condition;
    private String temperature;
    private final WeatherService weatherService;

    public WeatherView(WeatherService weatherService) {
        this.weatherService = weatherService;
        Weather weather = this.weatherService.getCityTemperature("katowice");
        WeatherViewCard weatherViewCard = createViewCard(
                weather.getCity(),
                weather.getWeatherCondition(),
                String.valueOf(weather.getTemperature()));
        this.add(weatherViewCard);
    }

    private WeatherViewCard createViewCard(String city, String conditionVal, String temperatureVal) {
        WeatherViewCard weatherViewCard = new WeatherViewCard(city);
        this.addClassNames(LumoUtility.JustifyContent.CENTER,
                LumoUtility.Gap.SMALL, LumoUtility.Height.MEDIUM,
                LumoUtility.Width.FULL);

        weatherViewCard.setCondition("Condition: " + conditionVal);
        weatherViewCard.setTemperature("Temperature: " + temperatureVal + "C");

        WeatherViewLogic weatherViewLogic = new WeatherViewLogic(this.weatherService, weatherViewCard);
        return weatherViewCard;
    }
}
