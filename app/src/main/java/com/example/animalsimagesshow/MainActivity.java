package com.example.animalsimagesshow;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnLogin1,btnLogin2,btnLogin3,btnLogin4;
    ImageView imageView;
    private static final int IMAGE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();
    }

    private void initializeViews(){

        imageView = findViewById(R.id.imageView);

        btnLogin1 = findViewById(R.id.btnLogin1);
        btnLogin2 = findViewById(R.id.btnLogin2);
        btnLogin3 = findViewById(R.id.btnLogin3);
        btnLogin4 = findViewById(R.id.btnLogin4);
    }

    private void initializeListeners(){
        btnLogin1.setOnClickListener(v -> sendImagesToDisplayActivity(new int[]{R.drawable.cat_image_1, R.drawable.cat_image_2, R.drawable.cat_image_3, R.drawable.cat_image_4}));
        btnLogin2.setOnClickListener(v -> sendImagesToDisplayActivity(new int[]{R.drawable.dog_image_1, R.drawable.dog_image_2, R.drawable.dog_image_3, R.drawable.dog_image_4}));
        btnLogin3.setOnClickListener(v -> sendImagesToDisplayActivity(new int[]{R.drawable.tiger_image_1, R.drawable.tiger_image_2, R.drawable.tiger_image_3, R.drawable.tiger_image_4}));
        btnLogin4.setOnClickListener(v -> sendImagesToDisplayActivity(new int[]{R.drawable.horse_image_1, R.drawable.horse_image_2, R.drawable.horse_image_3, R.drawable.horse_image_4}));

    }

    private void sendImagesToDisplayActivity(int[] imageResIds) {
        Intent intent = new Intent(MainActivity.this, ImagesActivity.class);
        intent.putExtra("imageResources", imageResIds);
        startActivityForResult(intent, IMAGE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            int selectedImageResId = data.getIntExtra("selectedImageResId", -1);
            if (selectedImageResId != -1) {
                // Set the selected image in the ImageView of MainActivity
                imageView.setImageResource(selectedImageResId);
            }
        }
    }
}