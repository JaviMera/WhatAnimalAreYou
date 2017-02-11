package javier.whatanimalareyou.model.animals.concretes;

import javier.whatanimalareyou.model.animals.AnimalBase;
import javier.whatanimalareyou.model.choices.ChoicePoints;

import java.util.ArrayList;

/**
 * Created by Javier on 10/4/2016.
 */

public class Dolphin extends AnimalBase {

    public Dolphin(int imageId) {
        super(
            "Dolphin",
            imageId);

        mPointsPerStatement = new ArrayList<Integer>(){
            {
                add(ChoicePoints.THREE);
                add(ChoicePoints.TWO);
                add(ChoicePoints.THREE);
                add(ChoicePoints.ONE);
                add(ChoicePoints.FOUR);
            }
        };
    }
}
