package com.khb.wicketturotial.lessonfive;

import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;

import java.util.List;

// A markup alapján rendereli az átadott lista modell tételeit.
public class NameList extends ListView<NameVO> {

    public NameList(String id, IModel<? extends List<NameVO>> model) {
        super(id, model);
    }

    @Override
    protected void populateItem(ListItem<NameVO> listItem) {
        IModel<NameVO> itemModel = listItem.getModel(); // Így kapjuk meg 1 tétel modelljét

        IModel<String> formattedNameModel = new FormattedNameModel(itemModel);
        listItem.add(new StatelessLink<String>("nameLink") {
            @Override
            public void onClick() {
                // Ne csináljon semmit!
            }
        }.setBody(formattedNameModel));
    }
}
