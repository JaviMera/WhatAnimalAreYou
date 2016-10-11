package com.example.javier.whatanimalareyou.model.animals.concretes;

import com.example.javier.whatanimalareyou.model.animals.AnimalBase;
import com.example.javier.whatanimalareyou.model.choices.ChoicePoints;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javier on 10/4/2016.
 */

public class RedPanda extends AnimalBase {

    public RedPanda(int imageId) {
        super("Red Panda", imageId);

        mPointsPerStatement = new ArrayList<Integer>(){
            {
                add(ChoicePoints.ONE);
                add(ChoicePoints.TWO);
                add(ChoicePoints.THREE);
                add(ChoicePoints.ONE);
                add(ChoicePoints.ONE);
            }
        };
    }
}
