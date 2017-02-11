package javier.whatanimalareyou.model.animals;

/**
 * Created by Javier on 10/8/2016.
 */

public abstract class AbstractFactory {

    public AnimalBase calculate(int points){

        return selectAnimal(points);
    }

    protected abstract AnimalBase selectAnimal(int points);
}
