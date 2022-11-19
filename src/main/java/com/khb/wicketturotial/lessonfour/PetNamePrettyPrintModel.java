package com.khb.wicketturotial.lessonfour;

import org.apache.wicket.model.IModel;

public class PetNamePrettyPrintModel implements IModel<String> {
    private final IModel<PetVO> chainedModel;

    public PetNamePrettyPrintModel(IModel<PetVO> chainedModel) {
        this.chainedModel = chainedModel;
    }

    @Override
    public String getObject() {
        String petName = this.chainedModel.getObject().getName();
        return String.format("Házikedvenc neve: %s", petName);
    }
}
