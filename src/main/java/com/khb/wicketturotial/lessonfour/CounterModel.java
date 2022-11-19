package com.khb.wicketturotial.lessonfour;

import org.apache.wicket.model.IModel;

// Egyedi viselkedéssel rendelkező saját modell
public class CounterModel implements IModel<Integer> {
    private Integer value = 0;

    @Override
    public Integer getObject() {
        return this.value;
    }

    public void increase() {
        if (this.value < 100) {
            this.value++;
        }
    }

    public void decrease() {
        if (this.value > 0) {
            this.value--;
        }
    }
}
