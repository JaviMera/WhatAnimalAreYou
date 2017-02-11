package javier.whatanimalareyou.model.animals;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Javier on 10/4/2016.
 */

public abstract class AnimalBase implements Comparable<AnimalBase> {

    private String mName;
    private int mImageId;

    protected List<Integer> mPointsPerStatement;

    protected AnimalBase(String name, int imageId){

        mName = name;
        mImageId = imageId;
    }

    public String getName(){
        return mName;
    }

    public int getImageId() {
        return mImageId;
    }

    public int totalPoints(){

        int points = 0;
        for(Integer p : mPointsPerStatement){
            points += p;
        }

        return points;
    }

    @NonNull
    @Override
    public int compareTo(AnimalBase otherAnimal) {

        if(totalPoints() < otherAnimal.totalPoints()){

            return -1;
        }
        else if(totalPoints() > otherAnimal.totalPoints()){

            return 1;
        }

        return 0;
    }
}
