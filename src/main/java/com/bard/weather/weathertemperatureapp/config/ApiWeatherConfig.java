package com.bard.weather.weathertemperatureapp.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("api-weather")
@Configuration
@Setter
@Getter
public class ApiWeatherConfig {
    private String weatherApiKey;
}
