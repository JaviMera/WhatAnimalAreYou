package com.example.javier.whatanimalareyou.ui.ResultsActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.javier.whatanimalareyou.R;
import com.example.javier.whatanimalareyou.ui.ActivityBase;
import com.example.javier.whatanimalareyou.ui.ActivityExtras;
import com.example.javier.whatanimalareyou.ui.MainActivity.MainActivity;

import java.util.Locale;

public class ResultsActivity extends ActivityBase implements ResultsActivityView {

    private ResultsActivityPresenter mPresenter;

    private ImageView mAnimalResultImageView;
    private AppCompatButton mStartOverButton;
    private AppCompatButton mCaptionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Typeface font = Typeface.createFromAsset(getAssets(), ActivityExtras.ANIMAL_APP_TYPEFACE);

        mPresenter = new ResultsActivityPresenter(this);

        String caption = getIntent().getExtras().getString(ActivityExtras.ANIMAL_CAPTION_KEY);
        mCaptionButton = getView(R.id.captionButtonView);
        mCaptionButton.setText(caption);

        String animalName = getIntent().getExtras().getString(ActivityExtras.ANIMAL_NAME_KEY);
        String animalResultText = getString(R.string.result_text);
        String formatedText = String.format(Locale.ENGLISH, animalResultText, animalName);
        mPresenter.showToastWithAnimalName(formatedText);

        Integer animalImageId = getIntent().getExtras().getInt(ActivityExtras.ANIMAL_IMAGE_ID_KEY);
        mAnimalResultImageView = getView(R.id.animalResultImageView);
        mPresenter.updateAnimalResultImageView(animalImageId);

        mStartOverButton = getView(R.id.startOverButton);
        mStartOverButton.setTypeface(font);
        mStartOverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.launchActivity(MainActivity.class);
            }
        });
    }

    @Override
    public void updateAnimalImageView(int imageId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageId);
        mAnimalResultImageView.setImageBitmap(bitmap);
    }

    @Override
    public void showToastWithAnimalName(String animalNameText) {

        Toast.makeText(this,
                animalNameText,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void launchActivity(Class newActivity) {

        Intent intent = new Intent(ResultsActivity.this, newActivity);
        startActivity(intent);
    }
}
