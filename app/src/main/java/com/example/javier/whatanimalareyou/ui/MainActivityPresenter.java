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
}
