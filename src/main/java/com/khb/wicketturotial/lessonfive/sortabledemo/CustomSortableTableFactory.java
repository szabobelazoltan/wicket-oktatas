package com.khb.wicketturotial.lessonfive.sortabledemo;

import com.khb.wicketturotial.lessonfive.NameVO;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.model.Model;

import java.util.Arrays;
import java.util.List;

// Factory osztály rendezhető táblázat példányosításához
public class CustomSortableTableFactory {

    // Ez a factory metód hozza létre a rendezhető táblázatunkat.
    public static DefaultDataTable<NameVO, String> createDataTable(String id, SortableNameDataProvider dataProvider) {
        return new DefaultDataTable<>(id, createColumns(dataProvider), dataProvider, 10);
    }

    private static List<IColumn<NameVO, String>> createColumns(SortableNameDataProvider dataProvider) {
        return Arrays.asList(
                new SortablePropertyColumn(Model.of("Cím"), "title", dataProvider),
                new SortablePropertyColumn(Model.of("Vezetéknév"), "firstName", dataProvider),
                new SortablePropertyColumn(Model.of("Keresztnév"), "lastName", dataProvider)
        );
    }
}
