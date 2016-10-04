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
    private String expectedText;

    @Before
    public void setUp() throws Exception {

        expectedText = "I'm more of a group type person";
        statement = new Statement(expectedText);
    }

    @Test
    public void statementInit() throws Exception {

        // Assert
        Assert.assertEquals(expectedText, statement.getText());
    }

    @Test
    public void setChoiceReturnsSelectedChoice() throws Exception {

        // Arrange
        ChoiceEnum expectedChoice = ChoiceEnum.Agree;

        // Act
        statement.setChoiceSelected(expectedChoice);
        ChoiceEnum actualChoice = statement.getChoiceSelected();

        // Assert
        Assert.assertEquals(expectedChoice, actualChoice);
    }
}
