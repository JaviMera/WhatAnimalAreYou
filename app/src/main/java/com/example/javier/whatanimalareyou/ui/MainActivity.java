package com.example.javier.whatanimalareyou.ui;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.javier.whatanimalareyou.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] choicesArray = getResources().getStringArray(R.array.choices_array);

        mSpinner = (Spinner)findViewById(R.id.choiceSpinnerView);
        ChoiceSpinnerAdapter spinnerAdapter = new ChoiceSpinnerAdapter(
            this,
            android.R.layout.simple_spinner_item,
            Typeface.createFromAsset(getAssets(), "fonts/LuckiestGuy.ttf"),
            new ArrayList<>(Arrays.asList(choicesArray))
            );

        mSpinner.setAdapter(spinnerAdapter);
    }
}
