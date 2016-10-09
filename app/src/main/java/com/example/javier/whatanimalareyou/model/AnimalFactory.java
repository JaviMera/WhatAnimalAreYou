package com.example.javier.whatanimalareyou.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Javier on 10/8/2016.
 */

public class AnimalFactory extends ResultFactory {

    private Map<Integer, AnimalBase> pointsRangeMap;

    public AnimalFactory(int numberOfStatements, int numberOfChoices, List<AnimalBase> animals){

        pointsRangeMap = new LinkedHashMap<>();

        int totalPoints = numberOfStatements * numberOfChoices;
        int animalRange = totalPoints / animals.size();
        int counter = 0;

        for(AnimalBase animal : AnimalList.getAnimals()){
            counter += animalRange;
            pointsRangeMap.put(counter, animal);
        }
    }

    @Override
    protected AnimalBase selectAnimal(int points) {

        for(Integer key : pointsRangeMap.keySet()) {

            if(points <= key){
                return pointsRangeMap.get(key);
            }
        }

        return null;
    }
}
