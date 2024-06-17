package com.bard.weather.weathertemperatureapp.model;

public class CityWeatherToWeatherConverter {

    public static Weather convert(CityWeather cityWeather){
        return new Weather(
                cityWeather.getCity(),
                cityWeather.getWeatherText(),
                cityWeather.getTemperature(),
                cityWeather.getLink()
        );
    }
}
