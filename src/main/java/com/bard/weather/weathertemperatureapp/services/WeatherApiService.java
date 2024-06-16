package com.bard.weather.weathertemperatureapp.services;


import com.bard.weather.weathertemperatureapp.config.ApiWeatherConfig;
import com.bard.weather.weathertemperatureapp.model.CityWeather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherApiService {
    private final RestClient restClient;
    private final ApiWeatherConfig apiWeatherConfig;


    public WeatherApiService(ApiWeatherConfig apiWeatherConfig) {
        this.apiWeatherConfig = apiWeatherConfig;
        this.restClient = RestClient.create();
    }

    private String getCityLocationKey(String city) throws JsonProcessingException {
        String locationEndpoint = "http://dataservice.accuweather.com/locations/v1/search?q=" + city + "&apikey=" + apiWeatherConfig.getWeatherApiKey();
        String rawResult = this.restClient.get()
                .uri(locationEndpoint)
                .retrieve()
                .body(String.class);
        JsonNode arrayNode = new ObjectMapper().readTree(rawResult);
        String key = "";
        if (arrayNode.isArray()) {
            key = arrayNode.get(0).get("Key").asText();
        }
        return key;
    }


    public CityWeather getWeatherForCity(String city) {
        String key = "";
        try {
            key = getCityLocationKey(city);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        String endpoint = "http://dataservice.accuweather.com/currentconditions/v1/"
                + key
                + "?details=true&apikey="
                + apiWeatherConfig.getWeatherApiKey();

        CityWeather[] weahter = this.restClient.get().uri(endpoint).retrieve().body(CityWeather[].class);

        CityWeather cityWeather = null;

        if (weahter != null && weahter.length > 0) {
            cityWeather = weahter[0];
            cityWeather.setCity(city);
        }

        return cityWeather;
    }





}
