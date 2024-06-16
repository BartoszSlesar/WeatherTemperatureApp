
package com.bard.weather.weathertemperatureapp.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "WeatherText",
        "IsDayTime",
        "Temperature",
        "Link"
})
@Data
public class CityWeather {

    @JsonProperty("WeatherText")
    private String weatherText;

    private String city;


    @JsonProperty("Val")
    private double temperature;

    @JsonProperty("Link")
    private String link;


    @JsonProperty("Temperature")
    private void setSourceFromJson(Map<String, Map<String, Object>> temperature) {
        Map<String, Object> metricValues = temperature.getOrDefault("Metric", new HashMap<>());
        this.temperature = (Double) metricValues.getOrDefault("Value", 0.0);
    }

    @JsonProperty("WeatherText")
    public String getWeatherText() {
        return weatherText;
    }

    @JsonProperty("WeatherText")
    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }


    @JsonProperty("Link")
    public String getLink() {
        return link;
    }

    @JsonProperty("Link")
    public void setLink(String link) {
        this.link = link;
    }

}
