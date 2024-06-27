package com.bard.weather.weathertemperatureapp.web.resultview;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class WeatherViewCard extends Composite<Div>
        implements HasComponents, HasSize {
    private Div div;
    private Div content;
    private H4 temperature;
    private H4 condition;
    private H2 title;
    private String titleText;

    public WeatherViewCard() {
        this.div = new Div();
        this.content = new Div();
        this.temperature = new H4();
        this.condition = new H4();
        this.title = new H2();
    }

    public WeatherViewCard(String titleText) {
        this();
        this.titleText = titleText;

    }

    @Override
    public Div initContent() {
        this.title.setText(titleText);
        this.title.addClassNames(LumoUtility.Background.CONTRAST_10,
                LumoUtility.TextColor.PRIMARY, LumoUtility.Padding.SMALL,
                LumoUtility.Border.BOTTOM,
                LumoUtility.BorderColor.CONTRAST_10);
        this.div.addClassNames(LumoUtility.Margin.MEDIUM, LumoUtility.Display.FLEX,
                LumoUtility.FlexDirection.COLUMN, LumoUtility.Border.ALL,
                LumoUtility.BorderColor.CONTRAST_10,
                LumoUtility.BorderRadius.SMALL,
                LumoUtility.BoxShadow.MEDIUM);
        this.content.addClassNames(LumoUtility.Flex.NONE,
                LumoUtility.Padding.SMALL, LumoUtility.Background.CONTRAST_5, LumoUtility.BorderRadius.SMALL);
        HorizontalLayout contentInternalLayout = new HorizontalLayout();
        contentInternalLayout.add(condition, temperature);
        this.content.add(contentInternalLayout);
        this.div.add(title, content);
        return div;
    }

    @Override
    public void add(Component... components) {
        content.add(components);
    }

    @Override
    public void remove(Component... components) {
        content.remove(components);
    }

    public String getTitle() {
        return title.getText();
    }

    public void setTitle(String title) {
        this.title.setText(title);


    }

    public String getTemperature() {
        return temperature.getText();
    }

    public void setTemperature(String temperature) {
        this.temperature.setText(temperature);
    }

    public String getCondition() {
        return condition.getText();
    }

    public void setCondition(String condition) {
        this.condition.setText(condition);
    }
}
