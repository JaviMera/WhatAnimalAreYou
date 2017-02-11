package javier.whatanimalareyou.model.animals;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Javier on 10/8/2016.
 */

public class AnimalList {

    private List<AnimalBase> mAnimals;

    public AnimalList(AnimalBase... animals) {

        mAnimals = Arrays.asList(animals);
    }

    public List<AnimalBase> getAnimals() {

        return mAnimals;
    }
}
