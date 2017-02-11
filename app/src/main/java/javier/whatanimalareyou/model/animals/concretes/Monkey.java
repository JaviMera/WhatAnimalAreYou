package javier.whatanimalareyou.model.animals.concretes;

import javier.whatanimalareyou.model.animals.AnimalBase;
import javier.whatanimalareyou.model.choices.ChoicePoints;

import java.util.ArrayList;

/**
 * Created by Javier on 10/4/2016.
 */

public class Monkey extends AnimalBase {

    public Monkey(int imageId) {
        super("Monkey", imageId);

        mPointsPerStatement = new ArrayList<Integer>() {
            {
                add(ChoicePoints.ONE);
                add(ChoicePoints.TWO);
                add(ChoicePoints.FOUR);
                add(ChoicePoints.THREE);
                add(ChoicePoints.ONE);
            }
        };
    }
}
