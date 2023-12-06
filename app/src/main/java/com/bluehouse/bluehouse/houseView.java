package com.bluehouse.bluehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class houseView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_view);
        FloatingActionButton home = findViewById(R.id.homeButton);
        Button edit = findViewById(R.id.edit);
        Intent prev = getIntent();
        home.setOnClickListener(view -> {
            Intent homeInt = new Intent(this, HomeScreen.class);
            startActivity(homeInt);
        });
        edit.setOnClickListener(view -> {
            //TODO: add edit activity
            //Intent edit = new Intent(this, BlueHouse.class);
            //startActivity(edit);
        });
        TextView tempText = findViewById(R.id.temperature);
        TextView humText = findViewById(R.id.humidity);
        TextView lightText = findViewById(R.id.lightLevel);
        TextView nameText = findViewById(R.id.curGreenhouse);
        nameText.setText("Green House #" + prev.getStringExtra("house"));
        tempText.setText(prev.getStringExtra("temp"));
        humText.setText(prev.getStringExtra("hum"));
        lightText.setText(prev.getStringExtra("light"));
    }
}