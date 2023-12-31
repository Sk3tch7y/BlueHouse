package com.bluehouse.bluehouse;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class addGreen extends AppCompatActivity {
    private SharedViewModel sharedViewModel;
    private ArrayList<Plant> selectedPlants = new ArrayList<>();
    private int TotTemp;
    private int TotHum;
    private int numPlant;
    private TextView textView6,textView7,textView8,textView9,textView10,textView11,textView12,textView13;

    CheckBox check1, check2, check3;

EditText e;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_green);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11= findViewById(R.id.textView11);
        textView12= findViewById(R.id.textView12);
        textView13= findViewById(R.id.textView13);
        check1 = findViewById(R.id.checkBox);
        check2 = findViewById(R.id.checkBox2);
        check3 = findViewById(R.id.checkBox3);
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        e = findViewById(R.id.editTextText);
        // No need to observe LiveData here, it will be observed in SharedViewModel

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(addGreen.this, addPlant.class), 1);
            }
        });
        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGreenhouse(v);
            }
        });
    }

    private void updateTextView(Plant selectedPlant) {
        if(textView6.getText().toString().equals("Empty")){
            textView6.setText(selectedPlant.getName());
            numPlant = 1;
            TotTemp += (Integer.parseInt(selectedPlant.getTemp().substring(0,2)));
            TotHum+= (Integer.parseInt(selectedPlant.getHumid().substring(0,2)));
            selectedPlants.add(selectedPlant);
        }
        else if(textView7.getText().toString().equals("Empty")){textView7.setText(selectedPlant.getName()); numPlant = 2; selectedPlants.add(selectedPlant);
        }
        else if(textView8.getText().toString().equals("Empty")){textView8.setText(selectedPlant.getName()); numPlant = 3;TotTemp += (Integer.parseInt(selectedPlant.getTemp().substring(0,2)));
            TotHum+= (Integer.parseInt(selectedPlant.getHumid().substring(0,2))); selectedPlants.add(selectedPlant);
        }
        else if(textView9.getText().toString().equals("Empty")){textView9.setText(selectedPlant.getName()); numPlant = 4;TotTemp += (Integer.parseInt(selectedPlant.getTemp().substring(0,2)));
            TotHum+= (Integer.parseInt(selectedPlant.getHumid().substring(0,2))); selectedPlants.add(selectedPlant);
        }
        else if(textView10.getText().toString().equals("Empty")){textView10.setText(selectedPlant.getName()); numPlant = 5;TotTemp += (Integer.parseInt(selectedPlant.getTemp().substring(0,2)));
            TotHum+= (Integer.parseInt(selectedPlant.getHumid().substring(0,2)));selectedPlants.add(selectedPlant);
        }
        else if(textView11.getText().toString().equals("Empty")){textView11.setText(selectedPlant.getName());numPlant = 6; TotTemp += (Integer.parseInt(selectedPlant.getTemp().substring(0,2)));
            TotHum+= (Integer.parseInt(selectedPlant.getHumid().substring(0,2)));selectedPlants.add(selectedPlant);
        }
        else if(textView12.getText().toString().equals("Empty")){textView12.setText(selectedPlant.getName());numPlant = 7; TotTemp += (Integer.parseInt(selectedPlant.getTemp().substring(0,2)));
            TotHum+= (Integer.parseInt(selectedPlant.getHumid().substring(0,2)));selectedPlants.add(selectedPlant);
        }
        else if(textView13.getText().toString().equals("Empty")){textView13.setText(selectedPlant.getName());numPlant = 8; TotTemp += (Integer.parseInt(selectedPlant.getTemp().substring(0,2)));
            TotHum+= (Integer.parseInt(selectedPlant.getHumid().substring(0,2)));selectedPlants.add(selectedPlant);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Retrieve the selected plant from the resultIntent
            Plant selectedPlant = (Plant) data.getSerializableExtra("newPlant");

            // Update the selected plant in the ViewModel
            sharedViewModel.setSelectedPlant(selectedPlant);

            // Call updateTextView to display the selected plant name
            updateTextView(selectedPlant);
    }
}

public void addGreenhouse(View v){
        Intent intent = new Intent(addGreen.this, beans.class);
        boolean temp = check1.isChecked();
        boolean humid = check2.isChecked();
        boolean light = check2.isChecked();
        String name = e.getText().toString();
        saveUserData(name, temp, humid, light, (TotTemp/numPlant), TotHum/numPlant, 1000 );

        Greenhouse g = new Greenhouse(name, temp, humid, light, selectedPlants);
        intent.putExtra("name", g.getName());
        intent.putExtra("Greenhouse",  g);
        startActivity(intent);
}
    private void saveUserData(String name, Boolean temp, Boolean humid, Boolean light, int AvgTemp, int AvgHum, int AvgLig ) {
        String GreenData = name + "," + temp + "," + humid + "," + light + "," + AvgTemp + "," + AvgHum + "," + AvgLig;
        try {
            File file = new File(getFilesDir(), "datafile.txt");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(GreenData);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}