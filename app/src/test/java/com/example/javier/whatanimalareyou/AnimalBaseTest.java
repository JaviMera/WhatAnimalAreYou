package com.example.javier.whatanimalareyou;

import com.example.javier.whatanimalareyou.model.animals.AnimalBase;
import com.example.javier.whatanimalareyou.model.animals.concretes.Tiger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Javier on 10/4/2016.
 */
public class AnimalBaseTest {

    private AnimalBase animal;
    private String expectedName = "Tiger";
    private int expectedImageId = 1234;

    @Before
    public void setUp() throws Exception {
        animal = new Tiger(expectedImageId);
    }

    @Test
    public void animalInit() throws Exception {

        //  Act
        String actualName = animal.getName();
        int actualImageId = animal.getImageId();

        // Assert
        assertEquals(expectedName, actualName);
        assertEquals(expectedImageId, actualImageId);
    }
}