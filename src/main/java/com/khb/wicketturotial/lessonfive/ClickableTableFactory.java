package com.khb.wicketturotial.lessonfive;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Arrays;
import java.util.List;

// Ez a factory osztály egy egyszerű táblázatot készít kattintható cellákkal.
public class ClickableTableFactory {
    public static IDataProvider<NameVO> createDataProvider(List<NameVO> items) {
        return new ListDataProvider<>(items);
    }

    public static DataTable<NameVO, String> createDataTable(String id, IDataProvider<NameVO> dataProvider) {
        return new DataTable<>(id, createColumns(), dataProvider, 10);
    }

    private static List<IColumn<NameVO, String>> createColumns() {
        return Arrays.asList(
                new PropertyColumn<>(Model.of("Cím"), "title"),
                new PropertyColumn<>(Model.of("Vezetéknév"), "firstName"),
                createClickableColumn(Model.of("Keresztnév"), "lastName")
        );
    }

    // Itt készítünk egy olyan PropertyColumn-ből származtatott példányt,
    // amelynek a cellája Label helyett kattintható linket tartalmaz.
    private static IColumn<NameVO, String> createClickableColumn(IModel<String> headerModel, String propertyExpression) {
        return new PropertyColumn<>(headerModel, propertyExpression) {
            @Override
            public void populateItem(Item<ICellPopulator<NameVO>> item, String componentId, IModel<NameVO> rowModel) {
                IModel<?> cellTextModel = getDataModel(rowModel); // Link szövegének modellje
                item.add(new AjaxLink<>(componentId, rowModel) {
                    // Kattintási esemény lekezelése
                    @Override
                    public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                        NameVO name = getModelObject();
                        ajaxRequestTarget.appendJavaScript(String.format("window.alert('%s %s');", name.getFirstName(), name.getLastName()));
                    }
                }.setBody(cellTextModel));
            }
        };
    }
}
