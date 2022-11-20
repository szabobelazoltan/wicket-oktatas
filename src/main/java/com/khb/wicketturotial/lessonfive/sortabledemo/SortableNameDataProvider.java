package com.khb.wicketturotial.lessonfive.sortabledemo;

import com.khb.wicketturotial.lessonfive.NameVO;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.util.SingleSortState;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SortableNameDataProvider implements ISortableDataProvider<NameVO, String> {
    private final List<NameVO> names;
    private final SingleSortState<String> sortState;

    private SortableNameDataProvider(List<NameVO> names) {
        this.names = names;
        this.sortState = new SingleSortState<>();
        this.sortState.setPropertySortOrder("firstName", SortOrder.ASCENDING);
    }

    @Override
    public ISortState<String> getSortState() {
        return this.sortState;
    }

    @Override
    public Iterator<? extends NameVO> iterator(long l, long l1) {
        int start = (int) Math.min(l, names.size()); // a táblázatban megjelenítendő első sor indexe
        int length = (int) Math.min(start + l1, names.size());  // mennyi elem jelenjen meg.
        return names
                .subList(start, length)
                .iterator();
    }

    @Override
    public long size() {
        return names.size();
    }

    @Override
    public IModel<NameVO> model(NameVO nameVO) {
        return Model.of(nameVO);
    }

    public void sort(String property) {
        Comparator<NameVO> comparator = getComparator(property); // Előkészítjük a comparator-t.
        SortParam<String> sortParam = sortState.getSort(); // Elkérjük a rendezés pillanatnyi állapotát.

        // Ha paraméterben átadott property-név egyezik a rendezés állapotában lévővel és növekvő a sorrend, akkor megfordítjuk a sorrendet.
        if (sortParam.getProperty().equals(property) && sortParam.isAscending()) {
            sortState.setPropertySortOrder(property, SortOrder.DESCENDING);
            comparator = comparator.reversed();
        } else {
            // Különben a paraméterben átadott property szerint növekvően rendezünk majd.
            sortState.setPropertySortOrder(property, SortOrder.ASCENDING);
        }
        Collections.sort(names, comparator); // Rendezés
    }

    // A propertyName (title, firstName, lastName) alapján a NameVO valamelyik getter-jével készítünk 1 Comparator példányt.
    private Comparator<NameVO> getComparator(String propertyName) {
        if (propertyName.equals("title")) {
            return Comparator.comparing(NameVO::getTitle);
        } else if (propertyName.equals("firstName")) {
            return Comparator.comparing(NameVO::getFirstName);
        } else if (propertyName.equals("lastName")) {
            return Comparator.comparing(NameVO::getLastName);
        } else {
            throw new RuntimeException("Unknown property");
        }
    }

    // Factory metódus, amely a NameDataProvider példányosítása előtt másolatot csinál a paraméterként átadott listából, hogy az intakt maradhasson.
    public static SortableNameDataProvider create(List<NameVO> names) {
        List<NameVO> copyOfSource = new ArrayList<>(names.size());
        copyOfSource.addAll(names);
        return new SortableNameDataProvider(copyOfSource);
    }
}
