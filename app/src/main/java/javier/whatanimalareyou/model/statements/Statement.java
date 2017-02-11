package javier.whatanimalareyou.model.statements;

/**
 * Created by Javier on 10/4/2016.
 */

public class Statement {

    private String mText;
    private int mNumber;
    private int mChoicePosition;

    public Statement(String text, int number){

        mText = text;
        mNumber = number;
        mChoicePosition = -1;
    }

    public String getText() {
        return mText;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setChoice(int choice) {
        mChoicePosition = choice;
    }

    public int getChoice() {
        return mChoicePosition;
    }
}
