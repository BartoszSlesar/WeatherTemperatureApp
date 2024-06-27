package com.bard.weather.weathertemperatureapp.web;


import com.bard.weather.weathertemperatureapp.model.Weather;
import com.bard.weather.weathertemperatureapp.services.WeatherService;
import com.bard.weather.weathertemperatureapp.web.data.WeatherViewLogic;
import com.bard.weather.weathertemperatureapp.web.resultview.WeatherView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("temperatures")
@PageTitle("Temperature App")
public class CityWeatherMainPage extends AppLayout {

    private final WeatherService weatherService;

    public CityWeatherMainPage(WeatherService weatherService) {

        this.weatherService = weatherService;
        WeatherView displayDataView = new WeatherView(weatherService);
        createAppView();
        setContent(displayDataView);
        getElement().getStyle().set("height", "100%");

    }

    private void createAppView() {
        H1 title = new H1("Temperature App");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)");
        HorizontalLayout topBar = new HorizontalLayout();
        topBar.addClassNames(LumoUtility.JustifyContent.CENTER,
                LumoUtility.Gap.SMALL, LumoUtility.Height.MEDIUM,
                LumoUtility.Width.FULL);
        topBar.add(title);
        topBar.getElement();
        addToNavbar(topBar);

    }


}
