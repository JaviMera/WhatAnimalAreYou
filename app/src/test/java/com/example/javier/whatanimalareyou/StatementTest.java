package com.example.javier.whatanimalareyou;

import com.example.javier.whatanimalareyou.model.ChoiceEnum;
import com.example.javier.whatanimalareyou.model.Statement;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Javier on 10/4/2016.
 */
public class StatementTest {

    private Statement statement;

    @Test
    public void statementInit() throws Exception {

        // Arrange
        String expectedText = "I'm more of a group type person";
        int expectedNumber = 1;
        String expectedInitialChoice = "";

        // Act
        statement = new Statement(expectedText, 1);

        // Assert
        Assert.assertEquals(expectedText, statement.getText());
        Assert.assertEquals(expectedNumber, statement.getNumber());
        Assert.assertEquals(expectedInitialChoice, statement.getChoice());
    }

    @Test
    public void getChoiceReturnsChoiceSelected() throws Exception {

        // Arrange
        String expectedChoice = "Totally Disagree";
        String expectedText = "I'm more of a group type person";
        int expectedNumber = 1;

        // Act
        statement = new Statement(expectedText, 1);

        // Act
        statement.setChoice(expectedChoice);

        // Assert
        Assert.assertEquals(expectedChoice, statement.getChoice());
    }
}
