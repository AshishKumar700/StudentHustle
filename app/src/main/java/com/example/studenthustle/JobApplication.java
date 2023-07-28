package com.example.studenthustle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class JobApplication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_application);
        Bundle b3 = getIntent().getExtras();
        String username = b3.getString("username2");
        EditText title = findViewById(R.id.editTextTextPersonName6);
        EditText skills = findViewById(R.id.editTextTextPersonName7);
        EditText exp = findViewById(R.id.editTextNumber);
        Button b = findViewById(R.id.button9);
        SQLiteDatabase db = openOrCreateDatabase("StudentHustle",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Application10(title VARCHAR, skills VARCHAR, exp VARCHAR);");
        b.setOnClickListener(view -> {
            String title1 = title.getText().toString();
            String skills1 = skills.getText().toString();
            String exp1 = exp.getText().toString();
            db.execSQL("INSERT INTO Application10 VALUES('"+title1+"','"+skills1+"','"+exp1+"');");
            Toast.makeText(getApplicationContext(), "Application saved!", Toast.LENGTH_SHORT).show();
        });
    }
}