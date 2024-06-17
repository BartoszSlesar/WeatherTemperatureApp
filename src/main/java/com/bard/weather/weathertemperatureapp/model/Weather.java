package com.bard.weather.weathertemperatureapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weatherId;

    private String city;

    private String weatherCondition;

    private double temperature;

    private String link;

    public Weather() {

    }

    public Weather(String city, String weatherCondition, double temperature, String link) {
        this.city = city;
        this.weatherCondition = weatherCondition;
        this.temperature = temperature;
        this.link = link;
    }
}
