package com.example.javier.whatanimalareyou.model;

import java.util.HashMap;

/**
 * Created by Javi on 10/7/2016.
 */

public class StatementResult {

    private static final int FIRST_CHOICE = 1;
    private static final int SECOND_CHOICE = 2;
    private static final int THIRD_CHOICE = 3;
    private static final int FOURTH_CHOICE = 4;
    private static final int FIFTH_CHOICE = 5;

    private static final Dolphin dolphinInstance = new Dolphin();
    private static final Tiger tigerInstance = new Tiger();
    private static final Elephant elephantInstance = new Elephant();
    private static final Monkey monkeyInstance = new Monkey();
    private static final RedPanda redPandaInstance = new RedPanda();

    private static HashMap<Integer, AnimalBase> firstStatementResults = new HashMap<Integer, AnimalBase>(){
        {put(FIRST_CHOICE, dolphinInstance);}
        {put(SECOND_CHOICE, tigerInstance);}
        {put(THIRD_CHOICE, elephantInstance);}
        {put(FOURTH_CHOICE, monkeyInstance);}
        {put(FIFTH_CHOICE, redPandaInstance);}
    };

    private static HashMap<Integer, AnimalBase> secondStatementResults = new HashMap<Integer, AnimalBase>(){
        {put(SECOND_CHOICE, dolphinInstance);}
        {put(FIFTH_CHOICE, tigerInstance);}
        {put(THIRD_CHOICE, elephantInstance);}
        {put(FOURTH_CHOICE, monkeyInstance);}
        {put(FIRST_CHOICE, redPandaInstance);}
    };

    private static HashMap<Integer, AnimalBase> thirdStatementResults = new HashMap<Integer, AnimalBase>(){
        {put(FIFTH_CHOICE, dolphinInstance);}
        {put(THIRD_CHOICE, tigerInstance);}
        {put(FIRST_CHOICE, elephantInstance);}
        {put(FOURTH_CHOICE, monkeyInstance);}
        {put(SECOND_CHOICE, redPandaInstance);}
    };

    private static HashMap<Integer, AnimalBase> fourthStatementResults = new HashMap<Integer, AnimalBase>(){
        {put(THIRD_CHOICE, dolphinInstance);}
        {put(SECOND_CHOICE, tigerInstance);}
        {put(FIRST_CHOICE, elephantInstance);}
        {put(FIFTH_CHOICE, monkeyInstance);}
        {put(FOURTH_CHOICE, redPandaInstance);}
    };

    private static HashMap<Integer, AnimalBase> fifthStatementResults = new HashMap<Integer, AnimalBase>(){
        {put(FOURTH_CHOICE, dolphinInstance);}
        {put(SECOND_CHOICE, tigerInstance);}
        {put(FIRST_CHOICE, elephantInstance);}
        {put(FIFTH_CHOICE, monkeyInstance);}
        {put(THIRD_CHOICE, redPandaInstance);}
    };

    private static HashMap<Integer, HashMap<Integer, AnimalBase>> resultMap = new HashMap<Integer, HashMap<Integer, AnimalBase>>()
    {
        {put(1, firstStatementResults);}
        {put(2, secondStatementResults);}
        {put(3, thirdStatementResults);}
        {put(4, fourthStatementResults);}
        {put(5, fifthStatementResults);}
    };

    public static AnimalBase get(int statementNumber, int choice) {

        return resultMap
            .get(statementNumber)
            .get(choice);
    }
}
