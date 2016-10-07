package com.example.javier.whatanimalareyou.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;

import java.util.List;

/**
 * Created by Javier on 10/5/2016.
 */

public class MainActivityPresenter {

    private MainActivityView mView;

    public MainActivityPresenter(MainActivityView view){
        mView = view;
    }

    public void updateViewTypeface(View view, Typeface font) {
        mView.updateViewTypeface(view, font);
    }

    public void setSpinnerAdapterView(Context ctx, int spinnerLayout, String fontPath, List<String> spinnerChoiceItems) {
        mView.setSpinnerAdapterView(ctx, spinnerLayout, fontPath, spinnerChoiceItems);
    }

    public void updateTextColor(View view, int color) {
        mView.updateTextColor(view, color);
    }

    public void setViewEnabled(View view, boolean enabled) {
        mView.setViewEnabled(view, enabled  );
    }

    public void updateStatementCountText(int current, int max) {
        mView.updateStatementCountTextViewText(current, max);
    }

    public void updateStatementText(String text) {
        mView.updateStatementTextViewText(text);
    }

    public void updateSpinnerSelectedItem(int choicePosition) {
        mView.updateSpinnerSelectedItem(choicePosition);
    }
}
