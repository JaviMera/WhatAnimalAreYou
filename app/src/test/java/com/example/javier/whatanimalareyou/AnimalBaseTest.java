package com.example.javier.whatanimalareyou;

import com.example.javier.whatanimalareyou.model.animals.AnimalBase;
import com.example.javier.whatanimalareyou.model.animals.concretes.Tiger;
import com.example.javier.whatanimalareyou.model.choices.ChoicePoints;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Javier on 10/4/2016.
 */
public class AnimalBaseTest {

    private AnimalBase animal;


    @Test
    public void animalInit() throws Exception {

        // Arrange
        String expectedName = "Tiger";
        int expectedImageId = 1234;

        //  Act
        animal = new Tiger(expectedImageId);
        String actualName = animal.getName();
        int actualImageId = animal.getImageId();

        // Assert
        assertEquals(expectedName, actualName);
        assertEquals(expectedImageId, actualImageId);
    }
}