package com.khb.wicketturotial.lessonfour;

import com.khb.wicketturotial.LessonBasePage;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;

import java.util.Locale;

public class LessonFourPage extends LessonBasePage {
    private IModel<Boolean> hunLangModel = Model.of(Boolean.FALSE);
    private AbstractLink hunLink;
    private AbstractLink enLink;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        // Példa statikus model készítésére
        IModel<String> staticModel = Model.of("Egy statikus model tartalma vagyok.");
        add(new Label("staticModelLabel", staticModel));

        // Példa resource model példányosítására
        IModel<String> resourceModel = new ResourceModel("lessonfour.demo");
        add(new Label("resourceModelLabel", resourceModel));
        // Kiegészítők nyelv-váltáshoz
        hunLink = createLanguageSwapLink("hunLink", Locale.forLanguageTag("hu-HU"), true);
        enLink = createLanguageSwapLink("enLink", Locale.ENGLISH, false);
        add(hunLink, enLink);

        // Példa property model használatára
        IModel<PetVO> petModel = Model.of(new PetVO("Vacak", "dog"));
        add(new Label("petNameLabel", new PropertyModel<>(petModel, "name")));
        add(new Label("petSpeciesLabel", new PropertyModel<>(petModel, "species")));

        // Példa CompoundPropertyModel megjelenítésére
        IModel<PetVO> petModelV2 = new CompoundPropertyModel<>(petModel);
        add(new LessonFourDisplayPanel("petDisplay", petModelV2));

        // Példa CompoundPropertyModel szerkesztésére
        add(new LessonFourFormPanel("petEditor", petModelV2));

        // Példa LoadableDetachableModel használatára
        IModel<String> heavyModel = new HeavyDataModel();
        add(new Label("heavyLabel", heavyModel));

        // Példa model chaining használatára
        IModel<String> chainingModel = new PetNamePrettyPrintModel(petModel);
        add(new Label("chainedModelLabel", chainingModel));

        // Példa egyedi model használatára
        CustomModel customModel = new CustomModel();
        Label customModelLabel = new Label("customModelLabel", customModel);
        customModelLabel.setOutputMarkupId(true);
        add(customModelLabel);
        add(new AjaxLink<Void>("decLink") {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                customModel.decrease();
                ajaxRequestTarget.add(customModelLabel);
            }
        });
        add(new AjaxLink<Void>("incLink") {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                customModel.increase();
                ajaxRequestTarget.add(customModelLabel);
            }
        });
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        enLink.setVisible(hunLangModel.getObject());
        hunLink.setVisible(!enLink.isVisible());
    }

    private AbstractLink createLanguageSwapLink(String id, Locale locale, boolean modelObject) {
        return new AjaxLink<Void>(id) {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                Session.get().setLocale(locale);
                hunLangModel.setObject(modelObject);
                ajaxRequestTarget.add(getParent());
            }
        };
    }
}
