package com.khb.wicketturotial.lessontwo;

import org.apache.wicket.markup.html.basic.Label;

public class LessonTwoBluePanel extends LessonTwoGreenPanel {
    public LessonTwoBluePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("blueLabel", "Kék"));
    }
}
