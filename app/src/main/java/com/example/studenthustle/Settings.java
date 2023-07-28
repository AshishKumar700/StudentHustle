package com.example.studenthustle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button b = findViewById(R.id.button8);
        Bundle b5 = getIntent().getExtras();
        String username = b5.getString("username4");
        Button c = findViewById(R.id.button15);
        SQLiteDatabase db = openOrCreateDatabase("StudentHustle",MODE_PRIVATE,null);
        b.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.this,MainActivity.class);
            startActivity(intent);
        });
        c.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.this,EditProfile.class);
            Bundle b6 = new Bundle();
            b6.putString("username5",username);
            intent.putExtras(b6);
            startActivity(intent);
        });
    }
}