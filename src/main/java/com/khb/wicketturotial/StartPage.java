package com.khb.wicketturotial;

import com.khb.wicketturotial.lessonone.LessonOnePage;
import com.khb.wicketturotial.lessontwo.LessonTwoPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class StartPage extends WebPage {

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new BookmarkablePageLink<>("lessonOneLink", LessonOnePage.class));
        add(new BookmarkablePageLink<>("lessonTwoLink", LessonTwoPage.class));
    }
}
