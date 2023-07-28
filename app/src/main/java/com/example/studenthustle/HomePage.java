package com.example.studenthustle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        SQLiteDatabase db = openOrCreateDatabase("StudentHustle",MODE_PRIVATE,null);
        TextView name = findViewById(R.id.textView35);
        Bundle b1 = getIntent().getExtras();
        String username = b1.getString("username");
        Button b = findViewById(R.id.button5);
        Button chat = findViewById(R.id.button7);
        Button view1 = findViewById(R.id.button23);
        Cursor resultSet = db.rawQuery("Select fname from Student where username = '" + username + "' ", null);
        resultSet.moveToFirst();
        name.setText(resultSet.getString(0)+"!");
        b.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, Preferences.class);
            Bundle b4 = new Bundle();
            b4.putString("username3",username);
            intent.putExtras(b4);
            startActivity(intent);
        });
        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this,Settings.class);
            Bundle b5 = new Bundle();
            b5.putString("username4",username);
            intent.putExtras(b5);
            startActivity(intent);
        });
        Button c = findViewById(R.id.button10);
        c.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this,JobApplication.class);
            Bundle b3 = new Bundle();
            b3.putString("username2",username);
            intent.putExtras(b3);
            startActivity(intent);
        });
        Button profile = findViewById(R.id.button13);
        profile.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, Profile.class);
            Bundle b2 = new Bundle();
            b2.putString("username1",username);
            intent.putExtras(b2);
            startActivity(intent);

        });
        chat.setOnClickListener(view -> {
            Intent intent =  new Intent(HomePage.this,Chat.class);
            startActivity(intent);
        });
        view1.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this,AppliedJobs.class);
            startActivity(intent);
        });
    }
}