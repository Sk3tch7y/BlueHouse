package com.bluehouse.bluehouse;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class addPlant extends AppCompatActivity {
Spinner spinner;
EditText name;
EditText temp;
        EditText humid;
    private SharedViewModel sharedViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);
         spinner = findViewById(R.id.spinner);
         name= findViewById(R.id.editTextText2);
         temp= findViewById(R.id.editTextText3);
         humid= findViewById(R.id.editTextText4);
        // Define an array of items for the spinner
        String[] items = {"other", "Sunflower", "Marigold", "Rose", "Fern", "Ivy", "Cactus", "Basil", "Succulent", "Tulip","Orchid", "Daffodil", "Pansy","Geranium", "Lavender", "Azalea"};

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSelectedPlant();
            }
        });
    }


    private void addSelectedPlant() {
        String selectedItem = spinner.getSelectedItem().toString();
        Plant selectedPlant;

        switch (selectedItem) {
            case "other":
                selectedPlant = new Plant(name.getText().toString(), temp.getText().toString(), humid.getText().toString());

                break;
            case "Sunflower":
                selectedPlant = new Plant("Sunflower", "24 C", "50%");

                break;
            case "Marigold": {
                Plant bean = new Plant("Marigold", "26 C", "50%");
                selectedPlant = bean;

                break;
            }
            case "Rose": {
                Plant bean = new Plant("Rose", "20 C", "50%");
                selectedPlant = bean;

                break;
            }
            case "Fern": {
                Plant bean = new Plant("Fern", "21 C", "65%");
                selectedPlant = bean;

                break;
            }
            case "Ivy": {
                Plant bean = new Plant("Ivy", "17 C", "50%");
                selectedPlant = bean;

                break;
            }
            case "Cactus": {
                Plant bean = new Plant("Cactus", "30 C", "25%");
                selectedPlant = bean;

                break;
            }
            case "Basil": {
                Plant bean = new Plant("Basil", "27 C", "50%");
                selectedPlant = bean;

                break;
            }
            case "Succulent": {
                Plant bean = new Plant("Succulent", "27 C", "20%");
                selectedPlant = bean;

                break;
            }
            case "Tulip": {
                Plant bean = new Plant("Tulip", "15 C", "50%");
                selectedPlant = bean;

                break;
            }
            case "Orchid": {
                Plant bean = new Plant("Orchid", "24 C", "55%");
                selectedPlant = bean;

                break;
            }
            case "Daffodil": {
                Plant bean = new Plant("Daffodil", "16 C", "50%");
                selectedPlant = bean;

                break;
            }
            case "Pansy": {
                Plant bean = new Plant("Pansy", "12 C", "50%");
                selectedPlant = bean;

                break;
            }
            case "Geranium": {
                Plant bean = new Plant("Geranium", "21 C", "50%");
                selectedPlant = bean;

                break;
            }
            case "Lavender": {
                Plant bean = new Plant("lavender", "26 C", "30%");
                selectedPlant = bean;

                break;
            }
            case "Azalea": {
                Plant bean = new Plant("Azalea", "20 C", "50%");
                selectedPlant = bean;

                break;
            }
            default:
                selectedPlant = new Plant("", "", "");
        }

        sharedViewModel.setSelectedPlant(selectedPlant);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("newPlant", selectedPlant);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
    public void returnClick(View v){
        Intent intent = new Intent(addPlant.this, addGreen.class);
        startActivity(intent);
    }
}