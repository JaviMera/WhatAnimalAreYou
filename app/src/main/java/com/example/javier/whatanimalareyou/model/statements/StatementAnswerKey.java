package com.example.javier.whatanimalareyou.model.statements;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Javier on 10/9/2016.
 */

public class StatementAnswerKey {

    private Map<Integer, Map<Integer, Integer>> mAnswerKeyMap;

    public StatementAnswerKey(List<int[]> statementAnswerKey, List<Integer> animalPoints){

        mAnswerKeyMap = new LinkedHashMap<>();
        for(int statement = 0 ; statement < statementAnswerKey.size() ; statement++){

            Map<Integer, Integer> choicePointsMap = new LinkedHashMap<>();
            int[] currentStatementChoiceAnswers = statementAnswerKey.get(statement);

            for(int choice = 0 ; choice < animalPoints.size() ; choice++) {

                choicePointsMap.put(
                    currentStatementChoiceAnswers[choice],
                    animalPoints.get(choice));
            }

            mAnswerKeyMap.put(statement, choicePointsMap);
        }
    }

    public Map<Integer, Map<Integer, Integer>> get() {

        return mAnswerKeyMap;
    }

    public int size() {
        return mAnswerKeyMap.size();
    }

    public int getPoints(int statement, int choice) {
        return mAnswerKeyMap.get(statement).get(choice);
    }
}