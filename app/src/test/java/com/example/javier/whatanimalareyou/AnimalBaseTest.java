package com.example.javier.whatanimalareyou;

import com.example.javier.whatanimalareyou.model.AnimalBase;
import com.example.javier.whatanimalareyou.model.Tiger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Javier on 10/4/2016.
 */
public class AnimalBaseTest {

    private AnimalBase animal;
    private String expectedName = "Tiger";
    private int expectedValue = 5;

    @Before
    public void setUp() throws Exception {
        animal = new Tiger();
    }

    @Test
    public void animalInit() throws Exception {

        // Arrange
        String actualName = animal.getName();
        int actualValue = animal.getValue();

        assertEquals(expectedName, actualName);
        assertEquals(expectedValue, actualValue);
    }
}