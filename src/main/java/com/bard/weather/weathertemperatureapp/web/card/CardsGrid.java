package com.bard.weather.weathertemperatureapp.web.card;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class CardsGrid extends Div {
    public CardsGrid() {

        addClassNames(LumoUtility.Display.GRID, LumoUtility.Grid.FLOW_COLUMN,
                LumoUtility.Grid.Column.COLUMNS_4,
                LumoUtility.Grid.Breakpoint.Small.COLUMNS_2,
                LumoUtility.Grid.Breakpoint.Large.COLUMNS_4,
                LumoUtility.Gap.LARGE);
    }
}
