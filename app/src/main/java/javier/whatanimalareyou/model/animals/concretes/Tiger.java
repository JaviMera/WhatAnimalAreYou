package javier.whatanimalareyou.model.animals.concretes;

import javier.whatanimalareyou.model.animals.AnimalBase;
import javier.whatanimalareyou.model.choices.ChoicePoints;

import java.util.ArrayList;

/**
 * Created by Javier on 10/4/2016.
 */
public class Tiger extends AnimalBase {

    public Tiger(int imageId)
    {
        super(
            "Tiger",
            imageId);

        mPointsPerStatement = new ArrayList<Integer>(){
            {
                add(ChoicePoints.FIVE);
                add(ChoicePoints.FIVE);
                add(ChoicePoints.FIVE);
                add(ChoicePoints.FIVE);
                add(ChoicePoints.FIVE);
            }
        };
    }
}
