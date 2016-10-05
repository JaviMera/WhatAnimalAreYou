package com.example.javier.whatanimalareyou.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.javier.whatanimalareyou.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private HashMap<Integer, TextView> mTextViewMap;

    private Spinner mChoiceSpinner;
    private TextView mStatementTextView;
    private TextView mStatementsCountTextView;

    private MainActivityPresenter mPresenter;

    private final String LUCKIEST_GUYS_FONT = "fonts/LuckiestGuy.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStatementTextView = getView(R.id.statementTextView);
        mStatementsCountTextView = getView(R.id.statementCountTextView);

        mTextViewMap = new HashMap<>();
        mTextViewMap.put(R.id.statementTextView, mStatementTextView);
        mTextViewMap.put(R.id.statementCountTextView, mStatementsCountTextView);

        mPresenter = new MainActivityPresenter(this);
        mPresenter.updateTextViewTypeface(R.id.statementTextView, LUCKIEST_GUYS_FONT);
        mPresenter.updateTextViewTypeface(R.id.statementCountTextView, LUCKIEST_GUYS_FONT);

        String[] choicesArray = getResources().getStringArray(R.array.choices_array);

        mChoiceSpinner = getView(R.id.choiceSpinnerView);
        mPresenter.setSpinnerAdapterView(
            this,
            R.layout.spinner_choice_item,
            LUCKIEST_GUYS_FONT,
            Arrays.asList(choicesArray));
    }

    @Override
    public void updateTextViewTypeface(int viewId, String path) {
        Typeface font = Typeface.createFromAsset(getAssets(), path);

        mTextViewMap
            .get(viewId)
            .setTypeface(font);
    }

    @Override
    public void setSpinnerAdapterView(Context ctx, int spinnerLayout, String fontPath, List<String> spinnerChoiceItems) {

        ChoiceSpinnerAdapter spinnerAdapter = new ChoiceSpinnerAdapter(
            ctx,
            R.layout.spinner_choice_item,
            LUCKIEST_GUYS_FONT,
            spinnerChoiceItems);

        mChoiceSpinner.setAdapter(spinnerAdapter);
    }

    private <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }
}
