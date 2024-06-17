package com.bard.weather.weathertemperatureapp.web.card;

import com.bard.weather.weathertemperatureapp.model.Weather;
import com.bard.weather.weathertemperatureapp.util.UpdateValueForFront;
import com.bard.weather.weathertemperatureapp.web.card.ResponsiveCardsView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureChangeListener implements UpdateValueForFront {

    private ResponsiveCardsView responsiveCardsView;


    @Override
    public void updateContent(Weather weather) {
        responsiveCardsView.getUI().ifPresent(ui -> ui.access(() -> {
            this.responsiveCardsView.populateCard(weather);
        }));

    }
}
