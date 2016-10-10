package com.example.javier.whatanimalareyou.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javier.whatanimalareyou.R;

import java.util.Locale;

public class ResultsActivity extends AppCompatActivity {

    private ImageView mAnimalResultImageView;
    private AppCompatButton mStartOverButton;

    private final String LUCKIEST_GUYS_FONT = "fonts/LuckiestGuy.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Typeface font = Typeface.createFromAsset(getAssets(), LUCKIEST_GUYS_FONT);

        mAnimalResultImageView = getView(R.id.animalResultImageView);
        String animalName = getIntent().getExtras().getString("animal");
        Integer animalImageId = getIntent().getExtras().getInt("imageId");

        String animalResultText = getString(R.string.result_text);

        Toast.makeText(this,
            String.format(Locale.ENGLISH, animalResultText, animalName),
            Toast.LENGTH_SHORT).show();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), animalImageId);
        mAnimalResultImageView.setImageBitmap(bitmap);

        mStartOverButton = getView(R.id.startOverButton);
        mStartOverButton.setTypeface(font);
    }

    private <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }
}
