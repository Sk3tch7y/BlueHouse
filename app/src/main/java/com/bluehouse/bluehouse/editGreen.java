package com.bluehouse.bluehouse;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class editGreen extends AppCompatActivity {
    CheckBox check1, check2, check3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_green);
        Intent intent = getIntent();
        String receivedValue1 = intent.getStringExtra("Greenhouse1");
        String receivedValue2 = intent.getStringExtra("Greenhouse2");
        String receivedValue3 = intent.getStringExtra("Greenhouse3");
         check1 = findViewById(R.id.checkBox4);
         check2 = findViewById(R.id.checkBox5);
         check3 = findViewById(R.id.checkBox6);
        check1.setText(receivedValue1);
        check2.setText(receivedValue2);
        check3.setText(receivedValue3);



    }
    public void onClick(View v){
        Intent intent = new Intent(editGreen.this, beans.class);
        if(check1.isChecked())intent.putExtra("green1", "1");
        if(check2.isChecked())intent.putExtra("green2", "2");
        if(check3.isChecked())intent.putExtra("green3", "3");
        startActivity(intent);


    }
    public void onBeans(View v){
        Intent intent = new Intent(editGreen.this, addGreen.class);
        startActivity(intent);
    }
}