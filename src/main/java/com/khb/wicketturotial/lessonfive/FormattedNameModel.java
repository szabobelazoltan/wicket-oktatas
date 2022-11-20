package com.khb.wicketturotial.lessonfive;

import org.apache.wicket.model.IModel;

// A listában a teljes név kiírását szolgáló chaining model
public class FormattedNameModel implements IModel<String> {
    private final IModel<NameVO> chainedModel;

    public FormattedNameModel(IModel<NameVO> chainedModel) {
        this.chainedModel = chainedModel;
    }

    @Override
    public String getObject() {
        NameVO vo = this.chainedModel.getObject();
        if (vo.getTitle() != null) {
            return String.format("%s %s %s", vo.getTitle(), vo.getFirstName(), vo.getLastName());
        } else {
            return String.format("%s %s", vo.getFirstName(), vo.getLastName());
        }
    }
}
