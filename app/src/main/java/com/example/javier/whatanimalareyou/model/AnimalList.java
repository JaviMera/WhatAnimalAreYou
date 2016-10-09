package com.example.javier.whatanimalareyou.model;

import com.example.javier.whatanimalareyou.model.animals.Dolphin;
import com.example.javier.whatanimalareyou.model.animals.Elephant;
import com.example.javier.whatanimalareyou.model.animals.Monkey;
import com.example.javier.whatanimalareyou.model.animals.RedPanda;
import com.example.javier.whatanimalareyou.model.animals.Tiger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Javier on 10/8/2016.
 */

public class AnimalList {

    private List<AnimalBase> mAnimals;

    public AnimalList(AnimalBase... animals) {

        mAnimals = Arrays.asList(animals);
    }

    public List<Integer> getPoints(){

        List<Integer> points = new ArrayList<>();
        for(AnimalBase animal : mAnimals){
            points.add(animal.getPoints());
        }

        return points;
    }

    public List<AnimalBase> getAnimals() {

        return mAnimals;
    }
}
