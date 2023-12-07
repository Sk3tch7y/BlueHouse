package com.bluehouse.bluehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;

public class Tutorial extends AppCompatActivity {

    private ImageView imageView;
    private int[] pictureResources = {R.drawable.gh1, R.drawable.gh2, R.drawable.gh3, R.drawable.gh4, R.drawable.gh5, R.drawable.gh6, R.drawable.gh7, R.drawable.gh8, R.drawable.gh9};
    private int currentPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        imageView = findViewById(R.id.imageView);
        Button backButton = findViewById(R.id.buttonBack);
        Button nextButton = findViewById(R.id.buttonNext);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPosition > 0) {
                    currentPosition--;
                    imageView.setImageResource(pictureResources[currentPosition]);
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPosition < pictureResources.length - 1) {
                    currentPosition++;
                    imageView.setImageResource(pictureResources[currentPosition]);
                } else {
                    // After the 12th picture, return to the main menu
                    currentPosition = 0;
                    Intent intent = new Intent(Tutorial.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        // Display the initial image
        imageView.setImageResource(pictureResources[currentPosition]);
    }
}