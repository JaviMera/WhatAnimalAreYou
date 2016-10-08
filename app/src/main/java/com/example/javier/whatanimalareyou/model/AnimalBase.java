package com.example.javier.whatanimalareyou.model;

/**
 * Created by Javier on 10/4/2016.
 */

public abstract class AnimalBase {

    protected String mName;

    protected AnimalBase(String name){

        mName = name;
    }

    public String getName(){
        return mName;
    }
}
