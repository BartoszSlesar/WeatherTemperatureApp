package com.bard.weather.weathertemperatureapp.web;


import com.bard.weather.weathertemperatureapp.model.Weather;
import com.bard.weather.weathertemperatureapp.services.WeatherService;
import com.bard.weather.weathertemperatureapp.web.card.ResponsiveCardsView;
import com.bard.weather.weathertemperatureapp.web.card.TemperatureChangeListener;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("temperatures")
public class CityWeatherMainPage extends AppLayout {

    private final WeatherService weatherService;

    public CityWeatherMainPage(WeatherService weatherService) {

        this.weatherService = weatherService;
        H1 title = new H1("Temperature App");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "var(--lumo-space-m)");
        addToNavbar(title);
        HorizontalLayout navigation = getNavigation();
        navigation.getElement();
        addToNavbar(title, navigation);
        Weather weather = this.weatherService.getCityTemperature("katowice");
        ResponsiveCardsView responsiveCardsView = new ResponsiveCardsView();
        responsiveCardsView.populateCard(weather);
        TemperatureChangeListener temperatureChangeListener = new TemperatureChangeListener(responsiveCardsView);
        this.weatherService.setUpdateValueForFront(temperatureChangeListener);
        setContent(responsiveCardsView);


        getElement().getStyle().set("height", "100%");

    }

    private HorizontalLayout getNavigation() {
        HorizontalLayout navigation = new HorizontalLayout();
        navigation.addClassNames(LumoUtility.JustifyContent.CENTER,
                LumoUtility.Gap.SMALL, LumoUtility.Height.MEDIUM,
                LumoUtility.Width.FULL);
        navigation.add();
        return navigation;
    }

}
