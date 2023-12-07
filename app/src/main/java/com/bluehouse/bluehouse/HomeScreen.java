package com.bluehouse.bluehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity implements RecyclerViewAdapter.OnGreenHouseListener, RecyclerViewAdapterVertical.OnNotificationListener {

    private ArrayList<GreenhouseData> mainGreenHouseList = new ArrayList<>();
    private ArrayList<Notification> mainNotificationList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        initGreenhouseArray(mainGreenHouseList);
        initNotificationArray(mainNotificationList);
        initRecyclerView();
        initRecyclerViewVertical();


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
                Intent home = new Intent(HomeScreen.this, HomeScreen.class);
                startActivity(home);
            }
        });

        FloatingActionButton settings = findViewById(R.id.settingButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settings = new Intent(HomeScreen.this, settings.class);
                startActivity(settings);
            }
        });
        FloatingActionButton green = findViewById(R.id.editGreenHouseButton);
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent green = new Intent(HomeScreen.this, beans.class);
                startActivity(green);
            }
        });
        FloatingActionButton tutorial = findViewById(R.id.tutorialButton);
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tutorial = new Intent(HomeScreen.this, Tutorial.class);
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


    private void initGreenhouseArray(ArrayList<GreenhouseData> list)   {

        //create 4 greenhouses for the sample
        list.add(new GreenhouseData(1, "Garden", true, true, true));
        list.add(new GreenhouseData(2, "Neighbours", true, true, true));
        list.add(new GreenhouseData(3, "MicroGreens", true, true, true));
        list.add(new GreenhouseData(4, "GreenHouse", true, true, true));

        //set the current greenhouse temps

        list.get(0).setCurrentTemp("22C");
        list.get(1).setCurrentTemp("20C");
        list.get(2).setCurrentTemp("27C");
        list.get(3).setCurrentTemp("24C");

        //set the current greenhouse humidity

        list.get(0).setCurrentHumidity("56%");
        list.get(1).setCurrentHumidity("57%");
        list.get(2).setCurrentHumidity("82%");
        list.get(3).setCurrentHumidity("75%");

        //set the current greenHouse light

        list.get(0).setCurrentLight("1000LUX");
        list.get(1).setCurrentLight("900LUX");
        list.get(2).setCurrentLight("1100LUX");
        list.get(3).setCurrentLight("1400LUX");

        //set the current greenHouse other

        list.get(0).setCurrentOther("!!!");
        list.get(1).setCurrentOther("");
        list.get(2).setCurrentOther("");
        list.get(3).setCurrentOther("***");
    }
    private void initNotificationArray(ArrayList<Notification> list)    {

        //initalized 4 greenhouse notifications
        list.add(new Notification(1, "Temp Warning", "Greenhouse #1 has a temperature warning in the last 24 hours"));
        list.add(new Notification(2, "Humidity Warning", "The current humidity of your microGreens garden is too high.  Please remedy the situation."));
        list.add(new Notification(3, "LOW LIGHT!", "Your garage greenhouse light level are lower than recommended."));
        list.add(new Notification(4, "Temp Warning", "Your Neighbour's greenhouse temperature has Stabilized!"));
        list.add(new Notification(5, "Humidity", "Your Neighbour's greenhouse temperature has Stabilized!"));



    }

    private void initRecyclerView(){
        LinearLayoutManager layOutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.greenhouseRV);
        recyclerView.setLayoutManager(layOutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mainGreenHouseList, this);
        recyclerView.setAdapter(adapter);
    }

    private void initRecyclerViewVertical(){
        LinearLayoutManager layOutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.notificationRV);
        recyclerView.setLayoutManager(layOutManager);
        RecyclerViewAdapterVertical adapter = new RecyclerViewAdapterVertical(this,mainNotificationList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onGreenHouseClick(int position) {
        Toast.makeText(getApplicationContext(), "GreenHouse # " + position + " clicked", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, houseView.class);
        intent.putExtra("house", "1");
        intent.putExtra("temp", mainGreenHouseList.get(position).getCurrentTemp());
        intent.putExtra("hum", mainGreenHouseList.get(position).getCurrentHumidity());
        intent.putExtra("light", mainGreenHouseList.get(position).getCurrentLight());
        startActivity(intent);

        //this is where we have to dump the intent for the new activity which should go to a new greenHouse
        //mNotes.get(position);     //this is the code from the online tutorial... but should be replaced with something like
        //greenHouseNames.get(position);  //maybe should include another thing in there which is the greenhouse Id.
       // Intent intent = new Intent(this, NewActivity.class);    //replace NewActivity with the name of the greenhouse activity.
       // startActivity(intent);

    }

    public void onNotificationClick(int position)   {
        Toast.makeText(getApplicationContext(), "Notification # " + position + " clicked", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, NotificationView.class);
        intent.putExtra("noteName", mainNotificationList.get(position).getName());
        intent.putExtra("noteContent", mainNotificationList.get(position).getContent());
        startActivity(intent);


    }
}