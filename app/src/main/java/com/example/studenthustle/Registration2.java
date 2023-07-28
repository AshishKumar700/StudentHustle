package com.example.studenthustle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Registration2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
        SQLiteDatabase db = openOrCreateDatabase("StudentHustle",MODE_PRIVATE,null);
        Bundle b1 = getIntent().getExtras();
        String fname = b1.getString("fname");
        String lname = b1.getString("lname");
        String email1 = b1.getString("email1");
        String phone1 = b1.getString("phone1");
        String address1 = b1.getString("address1");
        Spinner spinner = findViewById(R.id.spinner);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("CSE");
        arrayList.add("IT");
        arrayList.add("CCE");
        arrayList.add("DSE");
        arrayList.add("ECE");
        arrayList.add("EEE");
        arrayList.add("Mechanical");
        arrayList.add("Civil");
        arrayList.add("IP");
        arrayList.add("Automobile");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        Button b = findViewById(R.id.button4);
        EditText spec = findViewById(R.id.editTextTextPersonName4);
        EditText username = findViewById(R.id.editTextTextPersonName5);
        EditText password = findViewById(R.id.editTextTextPassword);
        EditText confirmPassword = findViewById(R.id.editTextTextPassword3);
        b.setOnClickListener(view -> {
            boolean validId = !TextUtils.isEmpty(spec.getText());
            boolean validUsername = !TextUtils.isEmpty(username.getText());
            boolean validPassword = !TextUtils.isEmpty(password.getText());
            boolean validConfirmPassword = !TextUtils.isEmpty(confirmPassword.getText());
            if(!validId){
                spec.setError("Cannot be left empty!");
            }
            if(!validUsername){
                username.setError("Cannot be left empty!");
            }
            if(!validPassword){
                password.setError("Cannot be left empty!");
            }
            if(!validConfirmPassword){
                confirmPassword.setError("Cannot be left empty!");
            }
            if(validId && validUsername && validPassword && validConfirmPassword) {
                Intent intent = new Intent(Registration2.this, MainActivity.class);
                String branch1 = spinner.getSelectedItem().toString();
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();
                String spec1 = spec.getText().toString();
                Cursor resultSet = db.rawQuery("Select username from Student where username = '" + username1 + "' ", null);
                Integer count = resultSet.getCount();
                if (count > 0) {
                    Toast.makeText(getApplicationContext(), "Username already exists!", Toast.LENGTH_SHORT).show();
                } else {
                    db.execSQL("INSERT INTO Student VALUES('" + username1 + "','" + password1 + "', '" + fname + "','" + lname + "', '" + email1 + "', '" + phone1 + "', '" + address1 + "', '" + branch1 + "', '" + spec1 + "' );");
                    Toast.makeText(getApplicationContext(), "Account Created Successfully!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });
    }
}