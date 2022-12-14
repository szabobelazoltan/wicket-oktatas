package com.khb.wicketturotial;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class LessonBasePage extends WebPage {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new Label("lessonTitle", getLessonTitle()));

        add(new BookmarkablePageLink<>("backLink", StartPage.class));
    }

    protected String getLessonTitle() {
        return null;
    }
}
