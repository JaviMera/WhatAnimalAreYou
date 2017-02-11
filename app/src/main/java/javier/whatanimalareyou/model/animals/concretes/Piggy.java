package javier.whatanimalareyou.model.animals.concretes;

import javier.whatanimalareyou.model.animals.AnimalBase;
import javier.whatanimalareyou.model.choices.ChoicePoints;

import java.util.ArrayList;

/**
 * Created by Javi on 10/10/2016.
 */

public class Piggy extends AnimalBase {

    public Piggy(int imageId) {
        super("Piggy", imageId);

        mPointsPerStatement = new ArrayList<Integer>(){
            {
                add(ChoicePoints.TWO);
                add(ChoicePoints.ONE);
                add(ChoicePoints.ONE);
                add(ChoicePoints.TWO);
                add(ChoicePoints.ONE);
            }
        };
    }
}
