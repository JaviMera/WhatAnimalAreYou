package com.example.javier.whatanimalareyou.model;

/**
 * Created by Javier on 10/4/2016.
 */

public class Statement {

    private String mText;
    private ChoiceEnum mChoiceSelected;

    public Statement(String text){

        mText = text;
    }

    public String getText() {
        return mText;
    }

    public ChoiceEnum getChoiceSelected() {
        return mChoiceSelected;
    }

    public void setChoiceSelected(ChoiceEnum mChoiceSelected) {
        this.mChoiceSelected = mChoiceSelected;
    }
}
