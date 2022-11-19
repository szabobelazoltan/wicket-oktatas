package com.khb.wicketturotial.lessonone;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.panel.Panel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LessonOnePanel extends Panel {
    public LessonOnePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        // Ezt a komponenst a <p wicket:id="myParagraph"></p> markup prezentálja a LessonOnePanel.html fájlban.
        Label label = new Label("myParagraph", "MyParagraph");
        add(label);

        Link<Void> myTimeStamp = new StatelessLink<Void>("myTimeStamp") {
            @Override
            public void onClick() {
                // most ne csináljon még semmit.
            }
        };
        Label myTimeStampLabel = new Label("myTimeStampLabel", DateTimeFormatter.ofPattern("YYYY. MM. dd. HH:mm:ss").format(LocalDateTime.now()));
        myTimeStamp.add(myTimeStampLabel); // MyTimeStampLabel legyen MyTimeStamp gyereke
        add(myTimeStamp);
    }
}
