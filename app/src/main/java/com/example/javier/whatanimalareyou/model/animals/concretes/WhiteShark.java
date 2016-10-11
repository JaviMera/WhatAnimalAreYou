package com.example.javier.whatanimalareyou.model.animals.concretes;

import com.example.javier.whatanimalareyou.model.animals.AnimalBase;
import com.example.javier.whatanimalareyou.model.choices.ChoicePoints;

import java.util.ArrayList;

/**
 * Created by Javi on 10/10/2016.
 */

public class WhiteShark extends AnimalBase {

    public WhiteShark(int imageId) {
        super("White Shark", imageId);

        mPointsPerStatement = new ArrayList<Integer>(){
            {
                add(ChoicePoints.THREE);
                add(ChoicePoints.FOUR);
                add(ChoicePoints.FIVE);
                add(ChoicePoints.ONE);
                add(ChoicePoints.FIVE);
            }
        };
    }
}
