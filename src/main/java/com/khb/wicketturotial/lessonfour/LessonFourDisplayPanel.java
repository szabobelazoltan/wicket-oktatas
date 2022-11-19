package com.khb.wicketturotial.lessonfour;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

public class LessonFourDisplayPanel extends GenericPanel<PetVO> {

    // A 2. argumentumban megkapja a CompoundPropertyModel példányt.
    public LessonFourDisplayPanel(String id, IModel<PetVO> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("name"));  // Hivatkozik a PetVO.name mezőre
        add(new Label("species")); // Hivatkozik a PetVO.species mezőre
    }
}
