package com.example.javier.whatanimalareyou.model;

import java.util.HashMap;

/**
 * Created by Javier on 10/4/2016.
 */

public class Statement {

    private String mText;
    private int mNumber;
    private String mChoice;

    public Statement(String text, int number){

        mText = text;
        mNumber = number;
        mChoice = "";
    }

    public String getText() {
        return mText;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setChoice(String choice) {
        this.mChoice = choice;
    }

    public String getChoice() {
        return mChoice;
    }
}
