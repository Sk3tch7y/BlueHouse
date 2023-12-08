package com.bluehouse.bluehouse;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class editGreen extends AppCompatActivity {
    List<String> lines = new ArrayList<>();
    File file = new File("datafile.txt");
    private String GH3Name;
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
        try {
            File file = new File(getFilesDir(), "datafile.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                check3.setText(userData[0]);
                GH3Name = userData[0];
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void onClick(View v){
        Intent intent = new Intent(editGreen.this, beans.class);
        if(check1.isChecked())intent.putExtra("green1", "1");
        if(check2.isChecked())intent.putExtra("green2", "2");
        if(check3.isChecked()){intent.putExtra("green3", "3");editGreen.removeLinesByPattern(this, GH3Name);};
        startActivity(intent);


    }
    public void onBeans(View v){
        Intent intent = new Intent(editGreen.this, addGreen.class);
        startActivity(intent);
    }
    public static void removeLinesByPattern(Context context, String patternToRemove) {
        File file = new File(context.getFilesDir(), "datafile.txt");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(patternToRemove + ",")) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}