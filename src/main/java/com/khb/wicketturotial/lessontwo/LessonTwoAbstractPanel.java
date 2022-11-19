package com.khb.wicketturotial.lessontwo;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class LessonTwoAbstractPanel extends Panel {
    public LessonTwoAbstractPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("timeStampLabel", getTimeStamp()));
    }

    private String getTimeStamp() {
        String timeStampLiteral = DateTimeFormatter.ofPattern("YYYY. MM. dd. HH:mm:ss").format(LocalDateTime.now());
        return String.format("Pontos idő: %s", timeStampLiteral);
    }
}
