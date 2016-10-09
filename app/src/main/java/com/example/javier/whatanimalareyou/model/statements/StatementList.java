package com.example.javier.whatanimalareyou.model.statements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javi on 10/6/2016.
 */

public class StatementList {

    private List<Statement> mStatements;
    private int mCurrent;

    public StatementList(){

        mStatements = new ArrayList<>();
        mCurrent = -1;
    }


    public int getCount() {
        return mStatements.size();
    }

    public void load(List<Statement> statements) {

        mStatements.addAll(statements);
    }

    public Statement get() {

        if(atLast())
            return null;

        mCurrent++;
        return mStatements.get(mCurrent);
    }

    public Statement previous() {

        if(atFirst())
            return null;

        mCurrent--;
        return mStatements.get(mCurrent);
    }

    public boolean atLast() {

        return mCurrent == getCount() - 1;
    }

    public boolean atFirst() {

        return mCurrent <= 0;
    }

    public int max() {

        return mStatements.size();
    }

    public List<Integer> getChoices() {

        List<Integer> choices = new ArrayList<>();

        for(Statement s : mStatements)
        {
            choices.add(s.getChoice());
        }

        return choices;
    }
}
