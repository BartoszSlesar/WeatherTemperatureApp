package com.bard.weather.weathertemperatureapp.services;


import com.bard.weather.weathertemperatureapp.model.CityWeather;
import com.bard.weather.weathertemperatureapp.model.Weather;
import com.bard.weather.weathertemperatureapp.repositories.CityTemperatureRepository;
import com.bard.weather.weathertemperatureapp.repositories.WeatherApiRepository;
import com.bard.weather.weathertemperatureapp.web.data.UpdateValueForFront;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.bard.weather.weathertemperatureapp.model.CityWeatherToWeatherConverter.convert;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class WeatherService {
    private final CityTemperatureRepository cityTemperatureRepository;
    private final WeatherApiRepository weatherApiRepository;
    private UpdateValueForFront updateValueForFront;

    @Transactional
    public Weather getCityTemperature(String city) {
        Optional<Weather> optionalCityWeather = this.cityTemperatureRepository.findWeatherByCity(city);
        if (optionalCityWeather.isEmpty()) {
            CityWeather cityWeather = this.weatherApiRepository.getWeatherForCity(city);
            if (cityWeather != null) {
                Weather weather = convert(cityWeather);
                this.cityTemperatureRepository.save(weather);
                return weather;
            }

        }

        return optionalCityWeather.orElseThrow(() -> new RuntimeException("Something went wrong with transaction"));

    }


    @Scheduled(cron = "${city-temperature.cron-job}")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void getCityWeatherUpdatedData() {
        List<String> cities = this.cityTemperatureRepository.findAll().stream().map(Weather::getCity).toList();
        cities.forEach(city -> {
            CityWeather cityWeather = this.weatherApiRepository.getWeatherForCity(city);
            this.cityTemperatureRepository.updateWeather(city,
                    cityWeather.getTemperature(),
                    cityWeather.getWeatherText());
            if (this.updateValueForFront != null) {
                this.updateValueForFront.updateContent();
            }
        });


    }


}
