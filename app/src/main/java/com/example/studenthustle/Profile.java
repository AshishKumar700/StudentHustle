package com.example.studenthustle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SQLiteDatabase db = openOrCreateDatabase("StudentHustle",MODE_PRIVATE,null);
        Bundle b2 = getIntent().getExtras();
        String username = b2.getString("username1");
        TextView fname = findViewById(R.id.textView31);
        TextView lname = findViewById(R.id.textView30);
        TextView email = findViewById(R.id.textView32);
        TextView phone = findViewById(R.id.textView33);
        TextView spec = findViewById(R.id.textView34);
        Cursor resultSet = db.rawQuery("Select fname, lname, email, phone, spec from Student where username = '"+username+"'",null);
        resultSet.moveToFirst();
        fname.setText(resultSet.getString(0));
        lname.setText(resultSet.getString(1));
        email.setText(resultSet.getString(2));
        phone.setText(resultSet.getString(3));
        spec.setText(resultSet.getString(4));

    }
}