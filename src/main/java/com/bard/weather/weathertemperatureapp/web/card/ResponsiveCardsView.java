package com.bard.weather.weathertemperatureapp.web.card;


import com.bard.weather.weathertemperatureapp.model.Weather;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class ResponsiveCardsView extends Div {


    private TemperatureChangeListener eventListener;
    private Card card;
    private Span conditions;
    private Span temperature;

    public ResponsiveCardsView() {
        CardsGrid grid = new CardsGrid();

        this.card = new Card("");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        this.conditions = new Span("");
        this.temperature = new Span("");
        horizontalLayout.add(conditions, temperature);
        card.add(horizontalLayout);
        grid.add(card);

        addClassNames(LumoUtility.Grid.FLOW_COLUMN,
                LumoUtility.Margin.MEDIUM,
                LumoUtility.JustifyContent.CENTER);
        add(grid);
    }

    public void populateCard(Weather weather) {
        this.card.setTitle(weather.getCity());
        this.conditions.setText(weather.getWeatherCondition());
        this.temperature.setText(String.valueOf(weather.getTemperature()) +" C");
    }


}

