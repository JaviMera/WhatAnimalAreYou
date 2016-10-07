package com.example.javier.whatanimalareyou;

import com.example.javier.whatanimalareyou.model.Statement;
import com.example.javier.whatanimalareyou.model.StatementList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javi on 10/6/2016.
 */
public class StatementListTest {

    private StatementList mStatementList;

    @Before
    public void SetUp() {

        mStatementList = new StatementList();
    }

    @Test
    public void init() throws Exception {

        // Arrange
        int expectedCount = 0;

        // Act
        int actualCount = mStatementList.getCount();

        // Assert
        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void loadStatements() throws Exception {

        // Arrange
        List<Statement> statements = createStatements();

        // Act
        mStatementList.load(statements);

        // Assert
        int expectedSize = statements.size();
        int actualSize = mStatementList.getCount();

        Assert.assertEquals(statements.size(), mStatementList.getCount());

        Statement expectedStatement = statements.get(0);
        Statement actualStatement = mStatementList.get();

        Assert.assertEquals(expectedStatement.getText(), actualStatement.getText());
    }

    @Test
    public void getStatementReturnsNullAfterLastStatement() throws Exception {

        // Arrange
        List<Statement> statements = createStatements();
        mStatementList.load(statements);

        // Act
        mStatementList.get(); // first statement
        mStatementList.get(); // second statement
        mStatementList.get(); // third statement
        mStatementList.get(); // fourth statement
        mStatementList.get(); // fifth statement

        Statement s = mStatementList.get(); // should return null

        // Assert
        Assert.assertNull(s);
    }

    @Test
    public void getPreviousReturnsPreviousStatement() throws Exception {

        // Arrange
        List<Statement> statements = createStatements();
        mStatementList.load(statements);
        Statement expectedPreviousStatement = statements.get(2);

        // Act
        mStatementList.get();
        mStatementList.get();
        mStatementList.get();
        mStatementList.get();

        Statement actualPreviousStatement = mStatementList.previous();

        // Assert
        Assert.assertEquals(expectedPreviousStatement.getText(), actualPreviousStatement.getText());
    }

    @Test
    public void getPreviousReturnsNullBeforeFirstStatement() throws Exception {

        // Arrange
        List<Statement> statements = createStatements();
        mStatementList.load(statements);

        // Act
        Statement s = mStatementList.previous();

        // Assert
        Assert.assertNull(s);
    }

    @Test
    public void atLastReturnsTrueAfterReturningLastStatement() throws Exception {

        // Arrange
        List<Statement> statements = createStatements();
        mStatementList.load(statements);

        // Act
        for(int i = 0 ; i < statements.size() ; i++)
            mStatementList.get();

        // Assert
        Assert.assertTrue(mStatementList.atLast());
    }

    @Test
    public void atFirstReturnsTrueAfterReturningFirstStatement() throws Exception {

        // Arrange
        List<Statement> statements = createStatements();
        mStatementList.load(statements);

        // Act
        mStatementList.get();
        mStatementList.previous();

        // Assert
        Assert.assertTrue(mStatementList.atFirst());
    }

    @Test
    public void maxReturnsMaxAmountOfStatements() throws Exception {

        // Arrange
        List<Statement> statements = createStatements();
        mStatementList.load(statements);
        int expectedMax = statements.size();

        // Act
        int actualMax = mStatementList.max();

        // Assert
        Assert.assertEquals(expectedMax, actualMax);
    }

    private List<Statement> createStatements(){

        return new ArrayList<Statement>()
        {
            {add(new Statement("Statement 1", 1));}
            {add(new Statement("Statement 2", 2));}
            {add(new Statement("Statement 3", 3));}
            {add(new Statement("Statement 4", 4));}
            {add(new Statement("Statement 5", 5));}
        };
    }
}