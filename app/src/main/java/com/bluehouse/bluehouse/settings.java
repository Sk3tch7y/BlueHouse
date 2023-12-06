package com.bluehouse.bluehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        FloatingActionButton popMenu = findViewById(R.id.popMenuButton);
        Button link = findViewById(R.id.pair);
        Group bottomMenu = findViewById(R.id.bottomMenu);
        FloatingActionButton exit = findViewById(R.id.closeButton);
        Button apply = findViewById(R.id.applyChanges);
        Button noti = findViewById(R.id.testNoti);
        ImageButton send = findViewById(R.id.sendId);

        TextView homeText = findViewById(R.id.homeText);
        TextView settingsText = findViewById(R.id.settingsText);
        TextView greenText = findViewById(R.id.editGreenText);
        TextView tutorialText = findViewById(R.id.tutorialText);


        FloatingActionButton home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(settings.this, HomeScreen.class);
                startActivity(home);
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
                Intent green = new Intent(settings.this, beans.class);
                startActivity(green);
            }
        });
        FloatingActionButton tutorial = findViewById(R.id.tutorialButton);
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent tutorial = new Intent(settings.this, Tutorial.class);
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
        
    
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slidein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottomslideup);
                bottomMenu.setVisibility(View.VISIBLE);
                int[] views = bottomMenu.getReferencedIds();
                for(int i = 0; i < views.length; i++){
                    findViewById(views[i]).startAnimation(slidein);
                }
            }
        });
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //turn on notifications'
                Intent intent = new Intent(getApplicationContext(), houseView.class);
                intent.putExtra("house", "1");
                intent.putExtra("temp", "40");
                intent.putExtra("hum", "50");
                intent.putExtra("light", "10000 Lum");
                PendingIntent notiPass = PendingIntent.getActivity(settings.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                CharSequence name = "channel_name";
                String description = "channel_description";
                int imp = NotificationManager.IMPORTANCE_HIGH;
                String ID = "BlueHouse";
                NotificationChannel testChannel = new NotificationChannel(ID, name, imp);
                testChannel.setDescription(description);
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(testChannel);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(settings.this, ID)
                        .setSmallIcon(R.drawable.menuassetdark)
                        .setContentTitle("BlueHouse Alert")
                        .setContentText("Issue with your BlueHouse #1")
                        .setPriority(imp)
                        .setContentIntent(notiPass);


                // notificationId is a unique int for each notification that you must define
                int notificationId = 1;
                notificationManager.notify(notificationId, builder.build());
            }



        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slideout = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottomslidedown);
                bottomMenu.setVisibility(View.INVISIBLE);
                int[] views = bottomMenu.getReferencedIds();
                for(int i = 0; i < views.length; i++){
                    findViewById(views[i]).startAnimation(slideout);
                }
            }
        });
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send a toast message saying that the changes have been applied
                Toast.makeText(getApplicationContext(), "Changes Applied", Toast.LENGTH_SHORT).show();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send a toast message saying that the changes have been applied
                Toast.makeText(getApplicationContext(), "BlueHouse device linked!", Toast.LENGTH_SHORT).show();
                exit.callOnClick();
            }
        });

    }
    
}