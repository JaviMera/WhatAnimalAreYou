package com.example.javier.whatanimalareyou.ui.MainActivity;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.javier.whatanimalareyou.R;

import java.util.List;

/**
 * Created by Javier on 10/4/2016.
 */

public class ChoiceSpinnerAdapter extends ArrayAdapter<String> {

    private LayoutInflater mInflater;
    private List<String> mChoices;
    private Typeface mFont;

    public ChoiceSpinnerAdapter(Context context, int spinnerLayout, String fontPath, List<String> choices) {
        super(context, spinnerLayout);

        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mFont = Typeface.createFromAsset(context.getAssets(), fontPath);
        mChoices = choices;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return mChoices.get(position);
    }

    @Override
    public int getPosition(String item) {
        return mChoices.indexOf(item);
    }

    @Override
    public int getCount() {
        return mChoices.size();
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        SpinnerDropDownItemHolder holder;
        View view = convertView;

        if(view == null){
            view = mInflater.inflate(R.layout.spinner_dropdown_choice_item, null);
            holder = new SpinnerDropDownItemHolder();
            holder.dropdownChoiceTextView = (TextView) view.findViewById(R.id.spinnerDropDownChoiceTextView);

            view.setTag(holder);
        }
        else
        {
            holder = (SpinnerDropDownItemHolder)view.getTag();
        }

        holder.dropdownChoiceTextView.setText(mChoices.get(position));
        holder.dropdownChoiceTextView.setTypeface(mFont);

        return view;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SpinnerItemHolder holder;
        View view = convertView;

        if(view == null){
            view = mInflater.inflate(R.layout.spinner_choice_item, null);
            holder = new SpinnerItemHolder();
            holder.choiceTextView = (TextView) view.findViewById(R.id.spinnerChoiceItemTextView);

            view.setTag(holder);
        }
        else
        {
            holder = (SpinnerItemHolder)view.getTag();
        }

        holder.choiceTextView.setText(mChoices.get(position));
        holder.choiceTextView.setTypeface(mFont);

        return view;
    }

    private class SpinnerItemHolder{

        TextView choiceTextView;
    }

    private class SpinnerDropDownItemHolder {

        TextView dropdownChoiceTextView;
    }
}