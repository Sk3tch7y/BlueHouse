package com.bluehouse.bluehouse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class beans extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beans);

        Button firstButton = findViewById(R.id.button4);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button secondButton = findViewById(R.id.button6);
        Button thirdButton = findViewById(R.id.button5);
        Button green1Button = findViewById(R.id.button2);
        Button green2Button = findViewById(R.id.button3);
        Intent intent = getIntent();
        String receivedValue1 = intent.getStringExtra("green1");
        String receivedValue2 = intent.getStringExtra("green2");
        String receivedValue3 = intent.getStringExtra("green3");
        String receivedValue4 = intent.getStringExtra("num");
        secondButton.setEnabled(false);

        if(receivedValue1!=null){
        green1Button.setText("Empty");
            green1Button.setEnabled(false);}
        if(receivedValue2!=null){
            green2Button.setText("Empty");
            green2Button.setEnabled(false);}
        if(receivedValue3!=null){
          secondButton.setText("Empty");
            secondButton.setEnabled(false);}
        FloatingActionButton popMenu = findViewById(R.id.popMenuButton);

        LinearLayout buttonmanager = findViewById(R.id.buttonContainer);
        TextView homeText = findViewById(R.id.homeText);
        TextView settingsText = findViewById(R.id.settingsText);
        TextView greenText = findViewById(R.id.editGreenText);
        TextView tutorialText = findViewById(R.id.tutorialText);
        Group side = findViewById(R.id.sidemenu);

        FloatingActionButton home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(beans.this, HomeScreen.class);
                startActivity(home);
            }
        });

        FloatingActionButton settings = findViewById(R.id.settingButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settings = new Intent(beans.this, settings.class);
                startActivity(settings);
            }
        });
        FloatingActionButton green = findViewById(R.id.editGreenHouseButton);
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent green = new Intent(beans.this, beans.class);
                startActivity(green);
            }
        });
        FloatingActionButton tutorial = findViewById(R.id.tutorialButton);
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent tutorial = new Intent(this, Tutorial.class);
                //startActivity(tutorial);
            }
        });

        final Boolean[] isMenuOpen = {false};
        popMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMenuOpen[0] = !isMenuOpen[0];
                System.out.println(isMenuOpen[0]);
                if(isMenuOpen[0]){
                    Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slideanimation);
                    //home

                    side.setVisibility(View.VISIBLE);
                    buttonmanager.startAnimation(slide_in);
                    home.startAnimation(slide_in);

                    homeText.startAnimation(slide_in);
                    //settings

                    settings.startAnimation(slide_in);

                    settingsText.startAnimation(slide_in);
                    //green

                    green.startAnimation(slide_in);

                    greenText.startAnimation(slide_in);
                    //tutorial

                    tutorial.startAnimation(slide_in);

                    tutorialText.startAnimation(slide_in);
                }
                else{
                    Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slideout);
                    //home
                    buttonmanager.startAnimation(slide_out);

                    home.startAnimation(slide_out);

                    homeText.startAnimation(slide_out);

                    //settings
                    settings.startAnimation(slide_out);

                    settingsText.startAnimation(slide_out);

                    //green
                    green.startAnimation(slide_out);

                    greenText.startAnimation(slide_out);

                    //tutorial
                    tutorial.startAnimation(slide_out);

                    tutorialText.startAnimation(slide_out);
                   side.setVisibility(View.INVISIBLE);
                }

            }
        });



        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(beans.this, editGreen.class);
                intent.putExtra("Greenhouse1",green1Button.getText().toString() );
                intent.putExtra("Greenhouse2",green2Button.getText().toString() );
                intent.putExtra("Greenhouse3",secondButton.getText().toString() );

                startActivity(intent);

            }
        });

        // Set click listener for the first button
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Your logic when the first button is clicked
                // For example, enable the second button
                Intent intent = new Intent(beans.this, addGreen.class);

                startActivity(intent);

            }
        });

        // Set click listener for the second button
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                Greenhouse newGreen = (Greenhouse) intent.getSerializableExtra("Greenhouse");

                Intent intents =  new Intent(beans.this, newGreen.class) ;
                intents.putExtra("Greenhouse",  newGreen);
                startActivity(intents);

            }
        });
        }
}