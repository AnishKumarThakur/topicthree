package com.e.topicthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    Spinner Spnr;
    AutoCompleteTextView actyBatch;
    Button btnSave;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.Name);
        Spnr = findViewById(R.id.Spnr);
        actyBatch = findViewById(R.id.actvBatch);
        btnSave = findViewById(R.id.btnSave);
        tvResult = findViewById(R.id.tvResult);

        String Countries [] = {"Nepal","China","Japan","Italy","Spain","USA","England","Dubai","Iraq","Korea"};
        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Countries

        );
        Spnr.setAdapter(adapter);
        String batch[] = {"22A","22B","22C","22D"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.select_dialog_item,
                batch
        );
        actyBatch.setAdapter(stringArrayAdapter);
        actyBatch.setThreshold(1);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, Country, Batch, str;

                name = Name.getText().toString();
                Country = Spnr.getSelectedItem().toString();
                Batch = actyBatch.getText().toString();

                str="Your Name" + name +"\nYour Country: "+ Country + "\nYour Batch:"+ Batch+"\n";
                tvResult.append(str);
            }
        });
    }
}
