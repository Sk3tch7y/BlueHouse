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

import java.util.ArrayList;

public class addGreen extends AppCompatActivity {
    private SharedViewModel sharedViewModel;
    private ArrayList<Plant> selectedPlants = new ArrayList<>();
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
    }

    private void updateTextView(Plant selectedPlant) {
       if(textView6.getText().toString().equals("Empty")){
        textView6.setText(selectedPlant.getName());
        selectedPlants.add(selectedPlant);
       }
       else if(textView7.getText().toString().equals("Empty")){textView7.setText(selectedPlant.getName()); selectedPlants.add(selectedPlant);
       }
       else if(textView8.getText().toString().equals("Empty")){textView8.setText(selectedPlant.getName()); selectedPlants.add(selectedPlant);
       }
       else if(textView9.getText().toString().equals("Empty")){textView9.setText(selectedPlant.getName());  selectedPlants.add(selectedPlant);
       }
       else if(textView10.getText().toString().equals("Empty")){textView10.setText(selectedPlant.getName()); selectedPlants.add(selectedPlant);
       }
       else if(textView11.getText().toString().equals("Empty")){textView11.setText(selectedPlant.getName()); selectedPlants.add(selectedPlant);
       }
       else if(textView12.getText().toString().equals("Empty")){textView12.setText(selectedPlant.getName()); selectedPlants.add(selectedPlant);
       }
       else if(textView13.getText().toString().equals("Empty")){textView13.setText(selectedPlant.getName()); selectedPlants.add(selectedPlant);
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
        Intent intent = new Intent(addGreen.this, MainActivity.class);
        boolean temp = check1.isChecked();
        boolean humid = check2.isChecked();
        boolean light = check2.isChecked();
        String name = e.getText().toString();
        Greenhouse g = new Greenhouse(name, temp, humid, light, selectedPlants);
        intent.putExtra("name", g.getName());
        intent.putExtra("Greenhouse",  g);
        startActivity(intent);
}
}