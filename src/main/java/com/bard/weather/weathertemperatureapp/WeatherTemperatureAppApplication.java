package com.bard.weather.weathertemperatureapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class WeatherTemperatureAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherTemperatureAppApplication.class, args);
	}

}
