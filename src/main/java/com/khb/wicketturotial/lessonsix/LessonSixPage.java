package com.khb.wicketturotial.lessonsix;

import com.khb.wicketturotial.LessonBasePage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;

public class LessonSixPage extends LessonBasePage {

    @Override
    protected void onInitialize() {
        super.onInitialize();

        CityModel cityModel = new CityModel();
        Label cityLabel = new Label("cityLabel", cityModel);
        cityLabel.setOutputMarkupId(true); // Ahhoz, hogy AJAX-válaszban tudjon újrarenderelődni a komponens, ezt TRUE-ra kell állítani.

        AjaxLink<Void> nextCityLink = new AjaxLink<Void>("nextCityLink") {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                cityModel.nextCity();
                ajaxRequestTarget.add(cityLabel);
            }
        };
        add(cityLabel, nextCityLink);

    }

    @Override
    protected String getLessonTitle() {
        return "Wicket Oktatóanyag - 6. Lecke: AJAX-kérés";
    }
}
