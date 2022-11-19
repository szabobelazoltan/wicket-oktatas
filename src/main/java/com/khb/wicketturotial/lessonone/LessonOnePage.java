package com.khb.wicketturotial.lessonone;

import com.khb.wicketturotial.StartPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class LessonOnePage extends WebPage {
    @Override
    protected void onInitialize() {
        super.onInitialize();

        // Ehhez a komponenshez a LessonOnePage.html fájlban a <h1 wicket:id="myNameLabel"></h1> markup tartozik.
        Label myName = new Label("myNameLabel", "1. lecke: Alapok");
        add(myName);

        add(new LessonOnePanel("myPanel"));


        add(new BookmarkablePageLink<>("backLink", StartPage.class));
    }
}
