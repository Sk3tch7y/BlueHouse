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
        FloatingActionButton home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(this, HomeScreen.class);
                startActivity(home);
            }
        });

        FloatingActionButton settings = findViewById(R.id.settingButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settings = new Intent(this, settings.class);
                startActivity(settings);
            }
        });
        FloatingActionButton green = findViewById(R.id.editGreenHouseButton);
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent green = new Intent(this, BlueHouse.class);
                startActivity(green);
            }
        });
        FloatingActionButton tutorial = findViewById(R.id.tutorialButton);
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tutorial = new Intent(this, Tutorial.class);
                startActivity(tutorial);
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
                    home.setVisibility(View.VISIBLE);
                    home.startAnimation(slide_in);
                    settings.setVisibility(View.VISIBLE);
                    settings.startAnimation(slide_in);
                    green.setVisibility(View.VISIBLE);
                    green.startAnimation(slide_in);
                    tutorial.setVisibility(View.VISIBLE);
                    tutorial.startAnimation(slide_in);
                }
                else{
                    Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slideout);
                    home.startAnimation(slide_out);
                    home.setVisibility(View.INVISIBLE);
                    settings.startAnimation(slide_out);
                    settings.setVisibility(View.INVISIBLE);
                    green.startAnimation(slide_out);
                    green.setVisibility(View.INVISIBLE);
                    tutorial.startAnimation(slide_out);
                    tutorial.setVisibility(View.INVISIBLE);
                }
                
            }
        });
    }
}