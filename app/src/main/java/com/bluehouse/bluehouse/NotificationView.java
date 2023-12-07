package com.bluehouse.bluehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class NotificationView extends AppCompatActivity {

    TextView notificationName, notificationContent;
    Button returnHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_view);

        Intent intent = getIntent();


        notificationName = findViewById(R.id.notification_name_notification_screen);
        notificationContent = findViewById(R.id.notification_content_notification_screen);
        returnHome = findViewById(R.id.return_home_button);

        notificationName.setText(intent.getStringExtra("noteName"));
        notificationContent.setText(intent.getStringExtra("noteContent"));

        //this sets the click listener  Written by Adam ( Fuck bro... This is clean... first time I have seen that as a lambda expression :)
        returnHome.setOnClickListener(view -> {
            Intent rtnHome = new Intent(this, HomeScreen.class);
            startActivity(rtnHome);
        });


        //code for buttons
        LinearLayout buttonmanager = findViewById(R.id.buttonContainer);
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
                Intent home = new Intent(NotificationView.this, HomeScreen.class);
                startActivity(home);
            }
        });

        FloatingActionButton settings = findViewById(R.id.settingButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settings = new Intent(NotificationView.this, settings.class);
                startActivity(settings);
            }
        });
        FloatingActionButton green = findViewById(R.id.editGreenHouseButton);
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent green = new Intent(NotificationView.this, beans.class);
                startActivity(green);
            }
        });
        FloatingActionButton tutorial = findViewById(R.id.tutorialButton);
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tutorial = new Intent(NotificationView.this, Tutorial.class);
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
                    sidemenu.setVisibility(View.VISIBLE);
                    buttonmanager.startAnimation(slide_in);
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
                    buttonmanager.startAnimation(slide_out);
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