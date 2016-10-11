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
import com.example.javier.whatanimalareyou.ui.MainActivity.MainActivity;

import java.util.Locale;

public class ResultsActivity extends AppCompatActivity {

    private ImageView mAnimalResultImageView;
    AppCompatButton mStartOverButton;

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
        mStartOverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }
}
