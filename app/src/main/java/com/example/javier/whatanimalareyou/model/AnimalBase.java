package com.example.javier.whatanimalareyou.model;

/**
 * Created by Javier on 10/4/2016.
 */

public abstract class AnimalBase {

    protected String mName;
    protected int mValue;

    protected AnimalBase(String name, int value){

        mName = name;
        mValue = value;
    }

    public String getName(){
        return mName;
    }

    public int getValue() {
        return mValue;
    }
}
