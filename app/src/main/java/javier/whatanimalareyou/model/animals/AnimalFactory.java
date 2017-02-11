package javier.whatanimalareyou.model.animals;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Javier on 10/8/2016.
 */

public class AnimalFactory extends AbstractFactory {

    private Set<AnimalBase> mAnimalSet;

    public AnimalFactory(List<AnimalBase> animals){

        mAnimalSet = new TreeSet<>(animals);
    }

    @Override
    protected AnimalBase selectAnimal(int points) {

        for(AnimalBase animal : mAnimalSet){
            if(points <= animal.totalPoints())
                return animal;
        }

        return null;
    }
}
