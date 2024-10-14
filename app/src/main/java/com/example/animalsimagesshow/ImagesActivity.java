package com.example.animalsimagesshow;

import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ImagesActivity extends AppCompatActivity {

    ImageView imgView1, imgView2, imgView3, imgView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images_activity);

        // Initialize the ImageViews
        imgView1 = findViewById(R.id.imgView1);
        imgView2 = findViewById(R.id.imgView2);
        imgView3 = findViewById(R.id.imgView3);
        imgView4 = findViewById(R.id.imgView4);

        // Get image resource IDs from the intent
        Intent intent = getIntent();
        int[] imageResIds = intent.getIntArrayExtra("imageResources");

        if (imageResIds != null && imageResIds.length >= 4) {
            // Set images to the ImageViews
            imgView1.setImageResource(imageResIds[0]);
            imgView2.setImageResource(imageResIds[1]);
            imgView3.setImageResource(imageResIds[2]);
            imgView4.setImageResource(imageResIds[3]);
        }
        imgView1.setOnClickListener(v -> returnImage(imageResIds[0]));
        imgView2.setOnClickListener(v -> returnImage(imageResIds[1]));
        imgView3.setOnClickListener(v -> returnImage(imageResIds[2]));
        imgView4.setOnClickListener(v -> returnImage(imageResIds[3]));
    }

    private void returnImage(int imageResId) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("selectedImageResId", imageResId);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

}
