package com.khb.wicketturotial.lessonfour;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

public class LessonFourFormPanel extends GenericPanel<PetVO> {

    public LessonFourFormPanel(String id, IModel<PetVO> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Form<PetVO> petForm = new Form<>("petForm", getModel());
        petForm.add(new TextField<>("name"));
        petForm.add(new TextField<>("species"));
        petForm.add(new AjaxSubmitLink("submitLink") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                super.onSubmit(target);
                target.add(getPage());
            }
        });

        add(petForm);
    }
}
