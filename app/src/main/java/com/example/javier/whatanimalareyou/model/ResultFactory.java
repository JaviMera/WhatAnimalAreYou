package com.example.javier.whatanimalareyou.model;

/**
 * Created by Javier on 10/8/2016.
 */

public abstract class ResultFactory {

    public AnimalBase calculate(int points){

        return selectAnimal(points);
    }

    protected abstract AnimalBase selectAnimal(int points);
}
