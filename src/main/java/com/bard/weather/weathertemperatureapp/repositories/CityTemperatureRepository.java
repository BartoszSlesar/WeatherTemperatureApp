package com.bard.weather.weathertemperatureapp.repositories;

import com.bard.weather.weathertemperatureapp.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CityTemperatureRepository extends JpaRepository<Weather, Long> {
    Optional<Weather> findWeatherByCity(String city);


    @Modifying
    @Query("UPDATE Weather set temperature = :temp, weatherCondition = :condition WHERE city = :city")
    void updateWeather(@Param(value = "city")
                       String city, @Param(value = "temp")
                       double temperature, @Param(value = "condition")
                       String condition);
}
