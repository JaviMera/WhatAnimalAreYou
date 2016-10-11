package com.example.javier.whatanimalareyou.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.javier.whatanimalareyou.R;
import com.example.javier.whatanimalareyou.model.animals.AnimalBase;
import com.example.javier.whatanimalareyou.model.animals.AnimalFactory;
import com.example.javier.whatanimalareyou.model.animals.AnimalList;
import com.example.javier.whatanimalareyou.model.animals.concretes.Crocodile;
import com.example.javier.whatanimalareyou.model.animals.concretes.Dolphin;
import com.example.javier.whatanimalareyou.model.animals.concretes.Elephant;
import com.example.javier.whatanimalareyou.model.animals.concretes.Hawk;
import com.example.javier.whatanimalareyou.model.animals.concretes.Monkey;
import com.example.javier.whatanimalareyou.model.animals.concretes.Piggy;
import com.example.javier.whatanimalareyou.model.animals.concretes.RedPanda;
import com.example.javier.whatanimalareyou.model.animals.concretes.Seal;
import com.example.javier.whatanimalareyou.model.animals.concretes.Tiger;
import com.example.javier.whatanimalareyou.model.animals.concretes.WhiteShark;
import com.example.javier.whatanimalareyou.model.statements.Statement;
import com.example.javier.whatanimalareyou.model.statements.StatementList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private AnimalList mAnimalList;
    private StatementList mStatementList;
    private Statement mCurrentStatement;

    private Spinner mChoiceSpinner;
    private TextView mStatementTextView;
    private TextView mStatementsCountTextView;
    private AppCompatButton mPreviousButtonView;
    private AppCompatButton mNextButtonView;
    private AppCompatButton mResultsButtonView;

    private MainActivityPresenter mPresenter;

    private final String LUCKIEST_GUYS_FONT = "fonts/LuckiestGuy.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface font = Typeface.createFromAsset(getAssets(), LUCKIEST_GUYS_FONT);

        mAnimalList = new AnimalList(
                new Dolphin(R.drawable.dolphin),
                new Elephant(R.drawable.elephant),
                new Monkey(R.drawable.monkey),
                new RedPanda(R.drawable.redpanda),
                new Tiger(R.drawable.tiger),
                new Crocodile(R.drawable.crocodile),
                new Hawk(R.drawable.hawk),
                new Piggy(R.drawable.piggy),
                new Seal(R.drawable.seal),
                new WhiteShark(R.drawable.whiteshark));

        final String[] choicesArray = getResources().getStringArray(R.array.choices_array);

        mStatementList = new StatementList();
        String[] statementArray = getResources().getStringArray(R.array.statements_array);
        initializeStatementsList(statementArray);

        mCurrentStatement = mStatementList.get();

        mStatementTextView = getView(R.id.statementTextView);
        mStatementsCountTextView = getView(R.id.statementCountTextView);

        mPreviousButtonView = getView(R.id.previousButtonView);
        mNextButtonView = getView(R.id.nextButtonView);

        mResultsButtonView = getView(R.id.resultsButton);
        mResultsButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int points = getUserPoints(mStatementList.getChoices());

                AnimalFactory factory = new AnimalFactory(
                    mAnimalList.getAnimals()
                );

                AnimalBase animal = factory.calculate(points);
                mPresenter.launchResultsActivity(animal.getName(), animal.getImageId());
            }
        });

        mPresenter = new MainActivityPresenter(this);
        mPresenter.updateViewTypeface(mStatementTextView, font);
        mPresenter.updateViewTypeface(mStatementsCountTextView, font);
        mPresenter.updateViewTypeface(mPreviousButtonView, font);
        mPresenter.updateViewTypeface(mNextButtonView, font);
        mPresenter.updateViewTypeface(mResultsButtonView, font);

        mPresenter.updateStatementText(mCurrentStatement.getText());
        mPresenter.updateStatementCountText(mCurrentStatement.getNumber(), mStatementList.max());


        mChoiceSpinner = getView(R.id.choiceSpinnerView);
        mPresenter.setSpinnerAdapterView(
            this,
            R.layout.spinner_choice_item,
            LUCKIEST_GUYS_FONT,
            Arrays.asList(choicesArray));

        mChoiceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int choicePosition, long l) {

                mCurrentStatement.setChoice(choicePosition);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private int getUserPoints(List<Integer> statementsAnwers) {

        int points = 0;
        for(int statementNumber = 0 ; statementNumber < statementsAnwers.size() ; statementNumber++)
        {
            int answer = statementsAnwers.get(statementNumber);
            points += answer + 1;
        }

        return points;
    }

    public void previousClick(View view) {

        if (mStatementList.atLast()) {

            mPresenter.setViewEnabled(mNextButtonView, true);
            mPresenter.updateTextColor(mNextButtonView, R.color.plain_white);
        }

        mCurrentStatement = mStatementList.previous();
        mPresenter.updateStatementText(mCurrentStatement.getText());
        mPresenter.updateStatementCountText(mCurrentStatement.getNumber(), mStatementList.max());

        updateSpinnerSelectedItem(mCurrentStatement);

        if (mStatementList.atFirst())
        {
            mPresenter.setViewEnabled(mPreviousButtonView, false);
            mPresenter.updateTextColor(mPreviousButtonView, R.color.disabled_text_color);
        }
    }

    public void nextClick(View view) {

        if(mStatementList.atFirst()){

            mPresenter.updateTextColor(mPreviousButtonView, R.color.plain_white);
            mPresenter.setViewEnabled(mPreviousButtonView, true);
        }

        mCurrentStatement = mStatementList.get();
        mPresenter.updateStatementText(mCurrentStatement.getText());
        mPresenter.updateStatementCountText(mCurrentStatement.getNumber(), mStatementList.max());

        updateSpinnerSelectedItem(mCurrentStatement);

        if(mStatementList.atLast())
        {
            mPresenter.setViewEnabled(mNextButtonView, false);
            mPresenter.updateTextColor(mNextButtonView, R.color.disabled_text_color);
            mResultsButtonView.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public void updateViewTypeface(View view, Typeface font) {

        if(view instanceof TextView)
        {
            ((TextView)view).setTypeface(font);
        }
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

    @Override
    public void updateStatementTextViewText(String text) {
        mStatementTextView.setText(text);
    }

    @Override
    public void updateSpinnerSelectedItem(int choicePosition) {
        mChoiceSpinner.setSelection(choicePosition);
    }

    @Override
    public void launchResultsActivity(String animalName, int imageId) {

        Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
        intent.putExtra("animal", animalName);
        intent.putExtra("imageId", imageId);
        startActivity(intent);
    }

    @Override
    public void updateTextColor(View view, int color) {

        if(view instanceof TextView)
        {
            ((TextView)view)
                .setTextColor(
                    ContextCompat.getColor(this, color));
        }
    }

    @Override
    public void setViewEnabled(View view, boolean enabled) {
        view.setEnabled(enabled);
    }

    @Override
    public void updateStatementCountTextViewText(int current, int max) {
        String text = String.format(Locale.ENGLISH, "%d of %d", current, max);
        mStatementsCountTextView.setText(text);
    }

    private <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    private void initializeStatementsList(String[] statementsText){

        List<Statement> statements = new ArrayList<>();
        for(int i = 0 ; i < statementsText.length ; i++)
        {
            statements.add(new Statement(statementsText[i], i + 1));
        }

        mStatementList.load(statements);
    }

    private void updateSpinnerSelectedItem(Statement currentStatement) {

        if(currentStatement.getChoice() == -1){

            currentStatement.setChoice(0);
            mPresenter.updateSpinnerSelectedItem(0);
        }
        else
        {
            mPresenter.updateSpinnerSelectedItem(currentStatement.getChoice());
        }
    }
}
