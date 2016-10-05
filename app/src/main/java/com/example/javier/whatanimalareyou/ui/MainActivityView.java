package com.example.javier.whatanimalareyou.ui;

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
}
