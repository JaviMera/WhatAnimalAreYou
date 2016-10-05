package com.example.javier.whatanimalareyou.ui;

import android.content.Context;

import java.util.List;

/**
 * Created by Javier on 10/5/2016.
 */

public interface MainActivityView {

    void updateTextViewTypeface(int viewId, String path);
    void setSpinnerAdapterView(Context ctx, int spinnerLayout, String fontPath, List<String> spinnerChoiceItems);
}
