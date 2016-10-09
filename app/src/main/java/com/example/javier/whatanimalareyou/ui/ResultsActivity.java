package com.example.javier.whatanimalareyou.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.javier.whatanimalareyou.R;

public class ResultsActivity extends AppCompatActivity {

    private TextView mAnimalResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mAnimalResultTextView = (TextView) findViewById(R.id.animalResultTextView);

        String animalName = getIntent().getExtras().getString("animal");
        mAnimalResultTextView.setText("You are a " + animalName);
    }
}
