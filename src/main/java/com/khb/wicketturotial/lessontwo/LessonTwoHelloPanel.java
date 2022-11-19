package com.khb.wicketturotial.lessontwo;

import org.apache.wicket.markup.html.basic.Label;

public class LessonTwoHelloPanel extends LessonTwoAbstractPanel {

    public LessonTwoHelloPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("greetingsLabel", "Hello World!"));
    }
}
