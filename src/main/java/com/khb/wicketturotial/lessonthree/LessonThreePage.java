package com.khb.wicketturotial.lessonthree;

import com.khb.wicketturotial.LessonBasePage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LessonThreePage extends LessonBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LessonThreePage.class);

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new LessonThreeLabel("notiLabel").setOutputMarkupId(true));
        add(new StatelessLink<Void>("reloadLink") {
            @Override
            public void onClick() {
                LOGGER.info("Életciklus indítása navigációval.");
                setResponsePage(LessonThreePage.class);
            }
        });
        add(new StatelessLink<Void>("renderLink") {
            @Override
            public void onClick() {
                LOGGER.info("Életciklus indítása HTTP-kéréssel.");
            }
        });
        add(new AjaxLink<Void>("ajaxRefreshLink") {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                LOGGER.info("Frissítés Ajax-kéréssel.");
                ajaxRequestTarget.add(getParent().get("notiLabel"));
            }
        });
    }
}
