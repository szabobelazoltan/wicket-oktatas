package com.khb.wicketturotial.lessonfive;

import com.khb.wicketturotial.LessonBasePage;
import com.khb.wicketturotial.lessonfive.sortabledemo.CustomSortableTableFactory;
import com.khb.wicketturotial.lessonfive.sortabledemo.SortableNameDataProvider;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Arrays;
import java.util.List;

public class LessonFiveExamplesPage extends LessonBasePage {
    @Override
    protected void onInitialize() {
        super.onInitialize();

        List<NameVO> names = Arrays.asList(
                new NameVO("Dr.", "Kiss", "Péter"),
                new NameVO("Id.", "Tóth", "Bendegúz"),
                new NameVO("Nagy", "Károly")
        );

        // ListView implementáció példányosítása
        IModel<List<NameVO>> nameListModel = Model.ofList(names);
        add(new NameList("nameList", nameListModel));

        // Kattintható táblázat példányosítása
        IDataProvider<NameVO> clickableDataProvider = ClickableTableFactory.createDataProvider(names);
        add(ClickableTableFactory.createDataTable("clickableTable", clickableDataProvider));

        // Rendezhető táblázat példányosítása
        SortableNameDataProvider sortableDataProvider = SortableNameDataProvider.create(names);
        add(CustomSortableTableFactory.createDataTable("sortableTable", sortableDataProvider));
    }

    @Override
    protected String getLessonTitle() {
        return "Wicket Oktatóanyag - 5. Lecke: Listák és táblázatok";
    }
}
