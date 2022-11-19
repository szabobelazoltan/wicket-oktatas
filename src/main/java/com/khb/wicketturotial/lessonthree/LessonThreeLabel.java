package com.khb.wicketturotial.lessonthree;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LessonThreeLabel extends Label {
    private static final Logger LOGGER = LoggerFactory.getLogger(LessonThreeLabel.class);

    public LessonThreeLabel(String id) {
        super(id, "Nézd meg mit írok a Console log-ra!");
        LOGGER.info("Létrejött a LessonThreeLabel egy példánya.");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        LOGGER.info("Az onInitialized() lefutott.");
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();

        LOGGER.info("Az onConfigure() lefutott.");
    }

    @Override
    protected void onBeforeRender() {
        super.onBeforeRender();

        LOGGER.info("Az onBeforeRender() lefutott.");
    }

    @Override
    protected void onRemove() {
        super.onRemove();

        LOGGER.info("Az onRemove() lefutott.");
    }

    @Override
    protected void onDetach() {
        super.onDetach();

        LOGGER.info("Az onDetach lefutott.");
    }
}
