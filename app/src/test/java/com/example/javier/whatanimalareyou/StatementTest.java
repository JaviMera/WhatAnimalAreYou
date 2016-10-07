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
    private int expectedNumber = 1;

    @Before
    public void setUp() throws Exception {

        expectedText = "I'm more of a group type person";
        statement = new Statement(expectedText, 1);
    }

    @Test
    public void statementInit() throws Exception {

        // Assert
        Assert.assertEquals(expectedText, statement.getText());
        Assert.assertEquals(expectedNumber, statement.getNumber());
    }
}
