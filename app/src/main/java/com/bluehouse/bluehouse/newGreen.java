package com.bluehouse.bluehouse;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class newGreen extends AppCompatActivity {
TextView t,v,a,b,c,d,e,f,g;
    Greenhouse newGreen;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_green);
        Intent intent = getIntent();
         newGreen = (Greenhouse) intent.getSerializableExtra("Greenhouse");
        t = findViewById(R.id.textView15);
        v = findViewById(R.id.textView26);
        a = findViewById(R.id.textView18);
        b = findViewById(R.id.textView21);
        c = findViewById(R.id.textView22);
        d = findViewById(R.id.textView23);
        e = findViewById(R.id.textView24);
        f = findViewById(R.id.textView25);
        g = findViewById(R.id.textView27);

        t.setText(newGreen.getName());
        ArrayList<Plant> bean = newGreen.getPlants();
        for(Plant p: bean){
            if(v.getText().toString().equals("Empty")){
                v.setText(p.getName());

            }
            else if(a.getText().toString().equals("Empty")){a.setText(p.getName());
            }
            else if(b.getText().toString().equals("Empty")){b.setText(p.getName());
            }
            else if(c.getText().toString().equals("Empty")){c.setText(p.getName());
            }
            else if(d.getText().toString().equals("Empty")){d.setText(p.getName());
            }
            else if(e.getText().toString().equals("Empty")){e.setText(p.getName());
            }
            else if(f.getText().toString().equals("Empty")){f.setText(p.getName());
            }
            else if(g.getText().toString().equals("Empty")){g.setText(p.getName());
            }
        }

    }
    public void home(View v){
        Intent intent = new Intent(newGreen.this, beans.class);
        intent.putExtra("been", newGreen.getName());
        startActivity(intent);
    }
}