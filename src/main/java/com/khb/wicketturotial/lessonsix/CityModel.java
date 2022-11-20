package com.khb.wicketturotial.lessonsix;

import org.apache.wicket.model.IModel;

public class CityModel implements IModel<String> {
    private static final String[] CITIES = { "Róma", "Berlin", "München", "Prága", "Bécs", "Budapest" };

    private int cityIdx = 0;

    @Override
    public String getObject() {
        return CITIES[this.cityIdx];
    }

    public void nextCity() {
        this.cityIdx++;
        if (this.cityIdx == CITIES.length) {
            this.cityIdx = 0;
        }
    }
}
