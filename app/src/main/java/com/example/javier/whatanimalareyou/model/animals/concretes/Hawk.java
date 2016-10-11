package com.example.javier.whatanimalareyou.model.animals.concretes;

import com.example.javier.whatanimalareyou.model.animals.AnimalBase;
import com.example.javier.whatanimalareyou.model.choices.ChoicePoints;

import java.util.ArrayList;

/**
 * Created by Javi on 10/10/2016.
 */

public class Hawk extends AnimalBase {

    public Hawk(int imageId) {
        super("Hawk", imageId);

        mPointsPerStatement = new ArrayList<Integer>(){
            {
                add(ChoicePoints.THREE);
                add(ChoicePoints.FIVE);
                add(ChoicePoints.THREE);
                add(ChoicePoints.TWO);
                add(ChoicePoints.FOUR);
            }
        };
    }
}
