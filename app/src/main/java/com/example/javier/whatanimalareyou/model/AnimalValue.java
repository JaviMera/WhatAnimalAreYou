package com.example.javier.whatanimalareyou.model;

import java.util.HashMap;

/**
 * Created by Javi on 10/7/2016.
 */

public class AnimalValue {

    private static HashMap<Class<?>, Integer> map = new HashMap<Class<?>, Integer>()
    {
        {put(Dolphin.class, 1);}
        {put(Elephant.class, 2);}
        {put(Monkey.class, 3);}
        {put(RedPanda.class, 4);}
        {put(Tiger.class, 5);}
    };

    public static int get(Class<?> key) {

        return map.get(key);
    }
}
