package com.example.studenthustle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        SQLiteDatabase db = openOrCreateDatabase("StudentHustle",MODE_PRIVATE,null);
        Bundle b6 = getIntent().getExtras();
        String username = b6.getString("username5");
        EditText fname = findViewById(R.id.editTextTextPersonName9);
        EditText lname = findViewById(R.id.editTextTextPersonName10);
        EditText email = findViewById(R.id.editTextTextPersonName11);
        EditText phone = findViewById(R.id.editTextTextPersonName12);
        EditText spec = findViewById(R.id.editTextTextPersonName13);
        Button update = findViewById(R.id.button16);
        update.setOnClickListener(view -> {
            String fname1 = fname.getText().toString();
            String lname1 = lname.getText().toString();
            String email1 = email.getText().toString();
            String phone1 = phone.getText().toString();
            String spec1 = spec.getText().toString();
            db.execSQL("Update Student set fname = '"+fname1+"', lname = '"+lname1+"', email = '"+email1+"', phone = '"+phone1+"', spec = '"+spec1+"' where username = '"+username+"'");
            Toast.makeText(getApplicationContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(EditProfile.this,HomePage.class);
            Bundle b4 = new Bundle();
            b4.putString("username",username);
            intent1.putExtras(b4);
            startActivity(intent1);
        });
    }
}