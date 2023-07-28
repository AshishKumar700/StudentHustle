package com.example.studenthustle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Preferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        Spinner spinner1 = findViewById(R.id.spinner2);
        Spinner spinner2 = findViewById(R.id.spinner3);
        Spinner spinner3 = findViewById(R.id.spinner4);
        Spinner spinner4 = findViewById(R.id.spinner5);
        Button next = findViewById(R.id.button6);
        Bundle b4 = getIntent().getExtras();
        String username = b4.getString("username3");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner3.setAdapter(arrayAdapter);

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("AM");
        arrayList1.add("PM");
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter1);
        spinner4.setAdapter(arrayAdapter1);
        next.setOnClickListener(view -> {
            Intent intent = new Intent(Preferences.this, Preferences2.class);
            Bundle b5 = new Bundle();
            b5.putString("username4",username);
            intent.putExtras(b5);
            startActivity(intent);
        });
    }
}