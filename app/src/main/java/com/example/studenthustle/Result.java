package com.example.studenthustle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle b6 = getIntent().getExtras();
        String username = b6.getString("username5");
        Button button1 = findViewById(R.id.button17);
        Button button2 = findViewById(R.id.button18);
        Button button3 = findViewById(R.id.button19);
        Button button4 = findViewById(R.id.button20);
        Button button5 = findViewById(R.id.button21);
        Button button6 = findViewById(R.id.button22);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(Result.this,Apply.class);
            Bundle b7 = new Bundle();
            String job = "Android Developer";
            b7.putString("username6",username);
            b7.putString("job",job);
            intent.putExtras(b7);
            startActivity(intent);
        });
        button2.setOnClickListener(view -> {
            Intent intent = new Intent(Result.this,Apply.class);
            Bundle b7 = new Bundle();
            String job = "Data Analytics";
            b7.putString("username6",username);
            b7.putString("job",job);
            intent.putExtras(b7);
            startActivity(intent);
        });
        button3.setOnClickListener(view -> {
            Intent intent = new Intent(Result.this,Apply.class);
            Bundle b7 = new Bundle();
            String job = "Delivery";
            b7.putString("username6",username);
            b7.putString("job",job);
            intent.putExtras(b7);
            startActivity(intent);
        });
        button4.setOnClickListener(view -> {
            Intent intent = new Intent(Result.this,Apply.class);
            Bundle b7 = new Bundle();
            String job = "Private Tutor";
            b7.putString("username6",username);
            b7.putString("job",job);
            intent.putExtras(b7);
            startActivity(intent);
        });
        button5.setOnClickListener(view -> {
            Intent intent = new Intent(Result.this,Apply.class);
            Bundle b7 = new Bundle();
            String job = "Library Manager";
            b7.putString("username6",username);
            b7.putString("job",job);
            intent.putExtras(b7);
            startActivity(intent);
        });
        button6.setOnClickListener(view -> {
            Intent intent = new Intent(Result.this,Apply.class);
            Bundle b7 = new Bundle();
            String job = "Web Developer";
            b7.putString("username6",username);
            b7.putString("job",job);
            intent.putExtras(b7);
            startActivity(intent);
        });
    }
}