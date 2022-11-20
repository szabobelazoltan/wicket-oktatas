package com.khb.wicketturotial.lessonfive.sortabledemo;

import com.khb.wicketturotial.lessonfive.NameVO;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.IModel;

public class SortablePropertyColumn extends PropertyColumn<NameVO, String> {
    private final SortableNameDataProvider dataProvider;

    public SortablePropertyColumn(IModel<String> displayModel, String propertyExpression, SortableNameDataProvider dataProvider) {
        super(displayModel, propertyExpression);
        this.dataProvider = dataProvider;
    }

    // A PropertyColumn implementációja 1 egyszerű Label példányt készít, így felüldefiniáljuk.
    // Helyette egy AjaxLink példányt hozunk létre, amely az oszlophoz tartozó mezőnév alapján
    // elindítja majd a rendezést és frissíti a táblázatot.
    @Override
    public Component getHeader(String componentId) {
        return new AjaxLink<Void>(componentId) {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                dataProvider.sort(getPropertyExpression());
                ajaxRequestTarget.add(getPage().get("sortableTable"));
            }
        }.setBody(getDisplayModel());
    }
}
