package javier.whatanimalareyou.model.animals.concretes;

import javier.whatanimalareyou.model.animals.AnimalBase;
import javier.whatanimalareyou.model.choices.ChoicePoints;

import java.util.ArrayList;

/**
 * Created by Javier on 10/4/2016.
 */

public class Elephant extends AnimalBase {

    public Elephant(int imageId) {

        super(
            "Elephant",
            imageId);

        mPointsPerStatement = new ArrayList<Integer>(){
            {
                add(ChoicePoints.FOUR);
                add(ChoicePoints.TWO);
                add(ChoicePoints.THREE);
                add(ChoicePoints.FOUR);
                add(ChoicePoints.FIVE);
            }
        };
    }
}
