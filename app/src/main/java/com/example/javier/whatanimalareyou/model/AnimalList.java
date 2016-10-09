package com.example.javier.whatanimalareyou.model;

import com.example.javier.whatanimalareyou.model.animals.Dolphin;
import com.example.javier.whatanimalareyou.model.animals.Elephant;
import com.example.javier.whatanimalareyou.model.animals.Monkey;
import com.example.javier.whatanimalareyou.model.animals.RedPanda;
import com.example.javier.whatanimalareyou.model.animals.Tiger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Javier on 10/8/2016.
 */

public class AnimalList {

    private static final Map<AnimalBase, Integer> animalPointsMap = new LinkedHashMap<AnimalBase, Integer>() {
        {
            put(new Dolphin(), 1);
            put(new Tiger(), 2);
            put(new Elephant(), 3);
            put(new Monkey(), 4);
            put(new RedPanda(), 5);
        }
    };

    public static List<AnimalBase> getAnimals() {

        return new ArrayList<>(animalPointsMap.keySet());
    }

    public static List<Integer> getPoints() {

        return new ArrayList<>(animalPointsMap.values());
    }

    public static int size() {
        return animalPointsMap.size();
    }
}
