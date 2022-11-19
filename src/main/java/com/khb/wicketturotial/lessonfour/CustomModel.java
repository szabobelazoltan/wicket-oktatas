package com.khb.wicketturotial.lessonfour;

import org.apache.wicket.model.IModel;

public class CustomModel implements IModel<Integer> {
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
