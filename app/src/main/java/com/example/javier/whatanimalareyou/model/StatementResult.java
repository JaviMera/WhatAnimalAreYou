package com.example.javier.whatanimalareyou.model;

import java.util.HashMap;

/**
 * Created by Javi on 10/7/2016.
 */

public class StatementResult {

    private static final int FIRST_CHOICE = 0;
    private static final int SECOND_CHOICE = 1;
    private static final int THIRD_CHOICE = 2;
    private static final int FOURTH_CHOICE = 3;
    private static final int FIFTH_CHOICE = 4;

    private static final int dolphinValue = 1;
    private static final int tigerValue = 2;
    private static final int elephantValue = 3;
    private static final int monkeyValue = 4;
    private static final int redPandaValue = 5;

    private static HashMap<Integer, Integer> firstStatementResults = new HashMap<Integer, Integer>(){
        {put(FIRST_CHOICE, dolphinValue);}
        {put(SECOND_CHOICE, tigerValue);}
        {put(THIRD_CHOICE, elephantValue);}
        {put(FOURTH_CHOICE, monkeyValue);}
        {put(FIFTH_CHOICE, redPandaValue);}
    };

    private static HashMap<Integer, Integer> secondStatementResults = new HashMap<Integer, Integer>(){
        {put(SECOND_CHOICE, dolphinValue);}
        {put(FIFTH_CHOICE, tigerValue);}
        {put(THIRD_CHOICE, elephantValue);}
        {put(FOURTH_CHOICE, monkeyValue);}
        {put(FIRST_CHOICE, redPandaValue);}
    };

    private static HashMap<Integer, Integer> thirdStatementResults = new HashMap<Integer, Integer>(){
        {put(FIFTH_CHOICE, dolphinValue);}
        {put(THIRD_CHOICE, tigerValue);}
        {put(FIRST_CHOICE, elephantValue);}
        {put(FOURTH_CHOICE, monkeyValue);}
        {put(SECOND_CHOICE, redPandaValue);}
    };

    private static HashMap<Integer, Integer> fourthStatementResults = new HashMap<Integer, Integer>(){
        {put(THIRD_CHOICE, dolphinValue);}
        {put(SECOND_CHOICE, tigerValue);}
        {put(FIRST_CHOICE, elephantValue);}
        {put(FIFTH_CHOICE, monkeyValue);}
        {put(FOURTH_CHOICE, redPandaValue);}
    };

    private static HashMap<Integer, Integer> fifthStatementResults = new HashMap<Integer, Integer>(){
        {put(FOURTH_CHOICE, dolphinValue);}
        {put(SECOND_CHOICE, tigerValue);}
        {put(FIRST_CHOICE, elephantValue);}
        {put(FIFTH_CHOICE, monkeyValue);}
        {put(THIRD_CHOICE, redPandaValue);}
    };

    private static HashMap<Integer, HashMap<Integer, Integer>> resultMap = new HashMap<Integer, HashMap<Integer, Integer>>()
    {
        {put(0, firstStatementResults);}
        {put(1, secondStatementResults);}
        {put(2, thirdStatementResults);}
        {put(3, fourthStatementResults);}
        {put(4, fifthStatementResults);}
    };

    public static int get(int statementNumber, int choice) {

        return resultMap
            .get(statementNumber)
            .get(choice);
    }
}
