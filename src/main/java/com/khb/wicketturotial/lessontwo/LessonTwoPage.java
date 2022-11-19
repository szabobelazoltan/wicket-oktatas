package com.khb.wicketturotial.lessontwo;

import com.khb.wicketturotial.StartPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class LessonTwoPage extends WebPage {
    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new LessonTwoHelloPanel("abstractHelloPanel"));
        add(new LessonTwoBluePanel("colorPanel"));

        add(new BookmarkablePageLink<>("backLink", StartPage.class));
    }
}
