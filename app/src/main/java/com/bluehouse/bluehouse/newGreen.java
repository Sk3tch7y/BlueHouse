package com.bluehouse.bluehouse;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class newGreen extends AppCompatActivity {
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_green);
        Intent intent = getIntent();
        Greenhouse newGreen = (Greenhouse) intent.getSerializableExtra("Greenhouse");
        t = findViewById(R.id.textView15);
        t.setText(newGreen.getName());

    }
}