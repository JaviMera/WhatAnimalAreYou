package com.example.javier.whatanimalareyou.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Javi on 10/7/2016.
 */

public class StatementResult {

    private static final int FIRST_CHOICE = 0;
    private static final int SECOND_CHOICE = 1;
    private static final int THIRD_CHOICE = 2;
    private static final int FOURTH_CHOICE = 3;
    private static final int FIFTH_CHOICE = 4;

    private static List<List<Integer>> statementsChoices;
    static{

        statementsChoices = new ArrayList<>();
        statementsChoices.add(new ArrayList<Integer>(){
            {
                add(FIRST_CHOICE);
                add(SECOND_CHOICE);
                add(THIRD_CHOICE);
                add(FOURTH_CHOICE);
                add(FIFTH_CHOICE);
            }
        });

        statementsChoices.add(new ArrayList<Integer>(){
            {
                add(SECOND_CHOICE);
                add(THIRD_CHOICE);
                add(FIFTH_CHOICE);
                add(FOURTH_CHOICE);
                add(FIRST_CHOICE);
            }
        });

        statementsChoices.add(new ArrayList<Integer>(){
            {
                add(FOURTH_CHOICE);
                add(FIRST_CHOICE);
                add(THIRD_CHOICE);
                add(SECOND_CHOICE);
                add(FIFTH_CHOICE);
            }
        });

        statementsChoices.add(new ArrayList<Integer>(){
            {
                add(FIRST_CHOICE);
                add(FIFTH_CHOICE);
                add(THIRD_CHOICE);
                add(SECOND_CHOICE);
                add(FOURTH_CHOICE);
            }
        });

        statementsChoices.add(new ArrayList<Integer>(){
            {
                add(SECOND_CHOICE);
                add(FIRST_CHOICE);
                add(FOURTH_CHOICE);
                add(FIFTH_CHOICE);
                add(THIRD_CHOICE);
            }
        });
    }

    private static HashMap<Integer, HashMap<Integer, Integer>> resultMap;
    static {

        resultMap = new HashMap<>();

        List<Integer> animalPoints = AnimalList.getPoints();

        for(int i = 0 ; i < statementsChoices.size() ; i++) {
            List<Integer> currentChoices = statementsChoices.get(i);

            HashMap<Integer, Integer> choicesPoints = new HashMap<>();
            for(int choice = 0 ; choice < currentChoices.size() ; choice++){

                choicesPoints.put(currentChoices.get(choice), animalPoints.get(choice));
            }

            resultMap.put(i,choicesPoints);
        }
    }

    public static int get(int statementNumber, int choice) {

        return resultMap
            .get(statementNumber)
            .get(choice);
    }
}
