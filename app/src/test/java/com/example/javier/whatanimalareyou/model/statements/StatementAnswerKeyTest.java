package com.example.javier.whatanimalareyou.model.statements;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Javier on 10/9/2016.
 */
public class StatementAnswerKeyTest {

    private StatementAnswerKey mAnswerKey;

    @Test
    public void init() throws Exception {

        // Arrange
        List<int[]> answerKeyList = createAnswerKeyList();

        List<Integer> points = createPoints();

        // Act
        mAnswerKey = new StatementAnswerKey(answerKeyList, points);

        // Assert
        Assert.assertNotNull(mAnswerKey.get());
        Assert.assertEquals(answerKeyList.size(), mAnswerKey.size());
    }

    @Test
    public void getPoints() throws Exception {

        // Arrange
        List<int[]> answerKeyList = createAnswerKeyList();
        List<Integer> points = createPoints();
        int statement = 0;
        int choice = 0;
        int expectedPoints = points.get(answerKeyList.get(statement)[choice]);

        // Act
        mAnswerKey = new StatementAnswerKey(answerKeyList, points);
        int actualPoints = mAnswerKey.getPoints(statement,choice);

        // Assert
        Assert.assertEquals(expectedPoints, actualPoints);
    }

    private List<int[]> createAnswerKeyList() {

        return new ArrayList<int[]>(){
            {
                add(new int[]{0,1,2,3,4});
                add(new int[]{0,2,4,3,1});
                add(new int[]{2,4,2,1,3});
                add(new int[]{4,1,0,2,3});
                add(new int[]{1,2,0,3,4});
            }
        };
    }

    private List<Integer> createPoints(){

        return new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };
    }
}