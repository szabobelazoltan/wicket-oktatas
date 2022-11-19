package com.khb.wicketturotial.lessonfour;

import org.apache.wicket.model.LoadableDetachableModel;

import java.io.IOException;
import java.io.InputStream;

// LoadableDetachableModel-ből származtatott osztály
public class HeavyDataModel extends LoadableDetachableModel<String> {
    private static final String RESOURCE_NAME = "heavy-source.txt";

    @Override
    protected String load() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(RESOURCE_NAME)) {
            byte[] byteData = inputStream.readAllBytes();
            return new String(byteData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
