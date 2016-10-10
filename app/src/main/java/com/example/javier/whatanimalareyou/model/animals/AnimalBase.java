package com.example.javier.whatanimalareyou.model.animals;

/**
 * Created by Javier on 10/4/2016.
 */

public abstract class AnimalBase {

    protected String mName;
    protected int mPointsWorth;
    protected int mImageId;

    protected AnimalBase(String name, int points, int imageId){

        mName = name;
        mPointsWorth = points;
        mImageId = imageId;
    }

    public String getName(){
        return mName;
    }

    public int getPoints() {
        return mPointsWorth;
    }

    public int getImageId() {
        return mImageId;
    }
}
