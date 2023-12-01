package com.bluehouse.bluehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
//import floatinactionbutton.FloatingActionButton;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class popMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_menu);
        FloatingActionButton popMenu = findViewById(R.id.popMenuButton);

        TextView homeText = findViewById(R.id.homeText);
        TextView settingsText = findViewById(R.id.settingsText);
        TextView greenText = findViewById(R.id.editGreenText);
        TextView tutorialText = findViewById(R.id.tutorialText);


        FloatingActionButton home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent home = new Intent(this, HomeScreen.class);
                //startActivity(home);
            }
        });

        FloatingActionButton settings = findViewById(R.id.settingButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent settings = new Intent(this, settings.class);
                //startActivity(settings);
            }
        });
        FloatingActionButton green = findViewById(R.id.editGreenHouseButton);
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent green = new Intent(this, BlueHouse.class);
                //startActivity(green);
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
                    home.setVisibility(View.VISIBLE);
                    home.startAnimation(slide_in);
                    homeText.setVisibility(View.VISIBLE);
                    homeText.startAnimation(slide_in);
                    //settings
                    settings.setVisibility(View.VISIBLE);
                    settings.startAnimation(slide_in);
                    settingsText.setVisibility(View.VISIBLE);
                    settingsText.startAnimation(slide_in);
                    //green
                    green.setVisibility(View.VISIBLE);
                    green.startAnimation(slide_in);
                    greenText.setVisibility(View.VISIBLE);
                    greenText.startAnimation(slide_in);
                    //tutorial
                    tutorial.setVisibility(View.VISIBLE);
                    tutorial.startAnimation(slide_in);
                    tutorialText.setVisibility(View.VISIBLE);
                    tutorialText.startAnimation(slide_in);
                }
                else{
                    Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slideout);
                    //home
                    home.startAnimation(slide_out);
                    home.setVisibility(View.INVISIBLE);
                    homeText.startAnimation(slide_out);
                    homeText.setVisibility(View.INVISIBLE);
                    //settings
                    settings.startAnimation(slide_out);
                    settings.setVisibility(View.INVISIBLE);
                    settingsText.startAnimation(slide_out);
                    settingsText.setVisibility(View.INVISIBLE);
                    //green
                    green.startAnimation(slide_out);
                    green.setVisibility(View.INVISIBLE);
                    greenText.startAnimation(slide_out);
                    greenText.setVisibility(View.INVISIBLE);
                    //tutorial
                    tutorial.startAnimation(slide_out);
                    tutorial.setVisibility(View.INVISIBLE);
                    tutorialText.startAnimation(slide_out);
                    tutorialText.setVisibility(View.INVISIBLE);
                }
                
            }
        });
    }
}