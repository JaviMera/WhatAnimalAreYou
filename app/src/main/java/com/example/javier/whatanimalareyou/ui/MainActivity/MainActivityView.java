package com.example.javier.whatanimalareyou.ui.MainActivity;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;

import java.util.List;

/**
 * Created by Javier on 10/5/2016.
 */

public interface MainActivityView {

    void updateViewTypeface(View view, Typeface font);
    void setSpinnerAdapterView(Context ctx, int spinnerLayout, String fontPath, List<String> spinnerChoiceItems);
    void updateTextColor(View view, int color);
    void setViewEnabled(View view, boolean enabled);
    void updateStatementCountTextViewText(int current, int max);
    void updateStatementTextViewText(String text);
    void updateSpinnerSelectedItem(int choicePosition);
    void launchResultsActivity(String animalName, int imageId, String caption);
}
