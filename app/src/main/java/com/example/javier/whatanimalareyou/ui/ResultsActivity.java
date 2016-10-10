package com.example.javier.whatanimalareyou.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javier.whatanimalareyou.R;

public class ResultsActivity extends AppCompatActivity {

    private TextView mAnimalResultTextView;
    private ImageView mAnimalResultImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mAnimalResultTextView = (TextView) findViewById(R.id.animalResultTextView);
        mAnimalResultImageView = (ImageView) findViewById(R.id.animalResultImageView);

        String animalName = getIntent().getExtras().getString("animal");
        Integer animalImageId = getIntent().getExtras().getInt("imageId");

        mAnimalResultTextView.setText("You are a " + animalName);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), animalImageId);
        mAnimalResultImageView.setImageBitmap(bitmap);
    }
}
