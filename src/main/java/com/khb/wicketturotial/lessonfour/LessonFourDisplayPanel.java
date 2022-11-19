package com.khb.wicketturotial.lessonfour;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

public class LessonFourDisplayPanel extends GenericPanel<PetVO> {

    public LessonFourDisplayPanel(String id, IModel<PetVO> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("name"));
        add(new Label("species"));
    }
}
