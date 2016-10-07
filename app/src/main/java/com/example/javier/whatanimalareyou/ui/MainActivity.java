package com.example.javier.whatanimalareyou.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javier.whatanimalareyou.R;
import com.example.javier.whatanimalareyou.model.ChoiceEnum;
import com.example.javier.whatanimalareyou.model.Statement;
import com.example.javier.whatanimalareyou.model.StatementList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private StatementList mStatements;
    private Statement mCurrentStatement;

    private Spinner mChoiceSpinner;
    private TextView mStatementTextView;
    private TextView mStatementsCountTextView;
    private AppCompatButton mPreviousButtonView;
    private AppCompatButton mNextButtonView;
    private MainActivityPresenter mPresenter;

    private final String LUCKIEST_GUYS_FONT = "fonts/LuckiestGuy.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface font = Typeface.createFromAsset(getAssets(), LUCKIEST_GUYS_FONT);

        mStatements = new StatementList();
        String[] statementArray = getResources().getStringArray(R.array.statements_array);
        initializeStatementsList(statementArray);

        mCurrentStatement = mStatements.get();

        mStatementTextView = getView(R.id.statementTextView);
        mStatementsCountTextView = getView(R.id.statementCountTextView);

        mPreviousButtonView = getView(R.id.previousButtonView);
        mNextButtonView = getView(R.id.nextButtonView);

        mPresenter = new MainActivityPresenter(this);
        mPresenter.updateViewTypeface(mStatementTextView, font);
        mPresenter.updateViewTypeface(mStatementsCountTextView, font);
        mPresenter.updateViewTypeface(mPreviousButtonView, font);
        mPresenter.updateViewTypeface(mNextButtonView, font);

        mPresenter.updateStatementText(mCurrentStatement.getText());
        mPresenter.updateStatementCountText(mCurrentStatement.getNumber(), mStatements.max());

        String[] choicesArray = getResources().getStringArray(R.array.choices_array);

        mChoiceSpinner = getView(R.id.choiceSpinnerView);
        mPresenter.setSpinnerAdapterView(
            this,
            R.layout.spinner_choice_item,
            LUCKIEST_GUYS_FONT,
            Arrays.asList(choicesArray));

        mChoiceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String choice = (String)adapterView.getItemAtPosition(i);
                mCurrentStatement.setChoice(choice);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void previousClick(View view) {

        if (mStatements.atLast()) {

            mPresenter.setViewEnabled(mNextButtonView, true);
            mPresenter.updateTextColor(mNextButtonView, R.color.plain_white);
        }

        mCurrentStatement = mStatements.previous();
        mPresenter.updateStatementText(mCurrentStatement.getText());
        mPresenter.updateStatementCountText(mCurrentStatement.getNumber(), mStatements.max());

        updateSpinnerSelectedItem(mChoiceSpinner, mCurrentStatement);

        if (mStatements.atFirst())
        {
            mPresenter.setViewEnabled(mPreviousButtonView, false);
            mPresenter.updateTextColor(mPreviousButtonView, R.color.disabled_text_color);
        }
    }

    public void nextClick(View view) {

        if(mStatements.atFirst()){

            mPresenter.updateTextColor(mPreviousButtonView, R.color.plain_white);
            mPresenter.setViewEnabled(mPreviousButtonView, true);
        }

        mCurrentStatement = mStatements.get();
        mPresenter.updateStatementText(mCurrentStatement.getText());
        mPresenter.updateStatementCountText(mCurrentStatement.getNumber(), mStatements.max());

        updateSpinnerSelectedItem(mChoiceSpinner, mCurrentStatement);

        if(mStatements.atLast())
        {
            mPresenter.setViewEnabled(mNextButtonView, false);
            mPresenter.updateTextColor(mNextButtonView, R.color.disabled_text_color);
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

        mStatements.load(statements);
    }

    private void updateSpinnerSelectedItem(Spinner choiceSpinner, Statement currentStatement) {

        ChoiceSpinnerAdapter adapter = (ChoiceSpinnerAdapter)choiceSpinner.getAdapter();

        if(currentStatement.getChoice().equals("")){

            String selectedChoice = adapter.getItem(0);
            currentStatement.setChoice(selectedChoice);
            mPresenter.updateSpinnerSelectedItem(0);
        }
        else
        {
            int currentStatementChoiceIndex = adapter.getPosition(currentStatement.getChoice());
            mPresenter.updateSpinnerSelectedItem(currentStatementChoiceIndex);
        }
    }
}
