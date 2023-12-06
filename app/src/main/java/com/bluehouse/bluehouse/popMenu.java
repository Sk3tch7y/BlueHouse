package com.bluehouse.bluehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
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

        //code for buttons
        FloatingActionButton popMenu = findViewById(R.id.popMenuButton);
        TextView homeText = findViewById(R.id.homeText);
        TextView settingsText = findViewById(R.id.settingsText);
        TextView greenText = findViewById(R.id.editGreenText);
        TextView tutorialText = findViewById(R.id.tutorialText);
        Group sidemenu = findViewById(R.id.sidemenu);

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
                    sidemenu.setVisibility(View.VISIBLE);
                    //home
                    home.startAnimation(slide_in);
                    homeText.startAnimation(slide_in);
                    //settings
                    settings.setVisibility(View.VISIBLE);
                    settings.startAnimation(slide_in);
                    settingsText.setVisibility(View.VISIBLE);
                    settingsText.startAnimation(slide_in);
                    //green
                    green.startAnimation(slide_in);
                    greenText.startAnimation(slide_in);
                    //tutorial

                    tutorial.startAnimation(slide_in);
                    tutorialText.startAnimation(slide_in);
                }
                else {
                    Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slideout);
                    //home
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
                    sidemenu.setVisibility(View.INVISIBLE);
                }
                
            }
        });
    }
}