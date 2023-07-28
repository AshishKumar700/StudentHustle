package com.example.studenthustle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Apply extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        SQLiteDatabase db = openOrCreateDatabase("StudentHustle",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Applied(jobtitle VARCHAR, company VARCHAR, location VARCHAR, applicationtitle VARCHAR);");
        Bundle b7 = getIntent().getExtras();
        String username = b7.getString("username6");
        String job = b7.getString("job");
        Button button = findViewById(R.id.button14);
        Spinner spinner = findViewById(R.id.spinner6);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Android Dev");
        arrayList.add("Web Dev");
        arrayList.add("Data Analytics");
        arrayList.add("Delivery");
        arrayList.add("Private Tutor");
        arrayList.add("Library Manager");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        button.setOnClickListener(view -> {
            String title = spinner.getSelectedItem().toString();
            Toast.makeText(getApplicationContext(), "Applied Successfully!", Toast.LENGTH_SHORT).show();
            if(job=="Android Developer") {
                db.execSQL("INSERT INTO Applied VALUES('" + job + "','Tata Consultancy Services','Bangalore,Karnataka','"+ title +"' );");
                Toast.makeText(getApplicationContext(), "Applied Successfully!", Toast.LENGTH_SHORT).show();
            }
            else if (job=="Data Analytics") {
                db.execSQL("INSERT INTO Applied VALUES('" + job + "','Manipal Dot Net Private Limited','Manipal,Karnataka','"+ title +"' );");
                Toast.makeText(getApplicationContext(), "Applied Successfully!", Toast.LENGTH_SHORT).show();
            }
            else if(job=="Delivery"){
                db.execSQL("INSERT INTO Applied VALUES('" + job + "','Swiggy','Manipal,Karnataka','"+ title +"' );");
                Toast.makeText(getApplicationContext(), "Applied Successfully!", Toast.LENGTH_SHORT).show();
            }
            else if(job=="Private Tutor"){
                db.execSQL("INSERT INTO Applied VALUES('" + job + "','MIT Manipal','Manipal,Karnataka','"+ title +"' );");
                Toast.makeText(getApplicationContext(), "Applied Successfully!", Toast.LENGTH_SHORT).show();
            }
            else if(job=="Library Manager"){
                db.execSQL("INSERT INTO Applied VALUES('" + job + "','KMC Library','Manipal,Karnataka','"+ title +"' );");
                Toast.makeText(getApplicationContext(), "Applied Successfully!", Toast.LENGTH_SHORT).show();
            }
            else if(job=="Web Developer"){
                db.execSQL("INSERT INTO Applied VALUES('" + job + "','Tata Consultancy Services','Bangalore,Karnataka','"+ title +"' );");
                Toast.makeText(getApplicationContext(), "Applied Successfully!", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(Apply.this,HomePage.class);
            Bundle b8 = new Bundle();
            b8.putString("username",username);
            intent.putExtras(b8);
            startActivity(intent);
        });


    }
}