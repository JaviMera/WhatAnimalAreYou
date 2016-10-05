package com.example.javier.whatanimalareyou.ui;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.javier.whatanimalareyou.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Spinner mChoiceSpinner;
    private TextView mStatementTextView;
    private TextView mStatementsCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/LuckiestGuy.ttf");

        mStatementTextView = (TextView)findViewById(R.id.statementTextView);
        mStatementTextView.setTypeface(font);

        mStatementsCountTextView = (TextView)findViewById(R.id.statementCountTextView);
        mStatementsCountTextView.setTypeface(font);

        String[] choicesArray = getResources().getStringArray(R.array.choices_array);

        mChoiceSpinner = (Spinner)findViewById(R.id.choiceSpinnerView);
        ChoiceSpinnerAdapter spinnerAdapter = new ChoiceSpinnerAdapter(
            this,
            android.R.layout.simple_spinner_item,
            font,
            new ArrayList<>(Arrays.asList(choicesArray))
            );

        mChoiceSpinner.setAdapter(spinnerAdapter);
    }
}
