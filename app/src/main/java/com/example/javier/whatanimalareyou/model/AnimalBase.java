package com.example.javier.whatanimalareyou.model;

/**
 * Created by Javier on 10/4/2016.
 */

public abstract class AnimalBase {

    protected String mName;
    protected int mPointsWorth;

    protected AnimalBase(String name, int points){

        mName = name;
        mPointsWorth = points;
    }

    public String getName(){
        return mName;
    }

    public int getPoints() {
        return mPointsWorth;
    }
}
