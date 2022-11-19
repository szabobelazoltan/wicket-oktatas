package com.khb.wicketturotial.lessontwo;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class LessonTwoGreenPanel extends Panel {
    public LessonTwoGreenPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("greenLabel", "Zöld"));
    }
}
