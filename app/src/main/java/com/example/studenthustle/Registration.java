package com.example.studenthustle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        SQLiteDatabase db = openOrCreateDatabase("StudentHustle",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Student(username VARCHAR primary key, password VARCHAR, fname VARCHAR, lname VARCHAR, email VARCHAR, phone VARCHAR, address VARCHAR, branch VARCHAR, spec VARCHAR);");
        Button b = findViewById(R.id.button3);
        EditText firstname = findViewById(R.id.editTextTextPersonName2);
        EditText lastname = findViewById(R.id.editTextTextPersonName3);
        EditText email = findViewById(R.id.editTextTextEmailAddress);
        EditText phone = findViewById(R.id.editTextPhone);
        EditText address = findViewById(R.id.editTextTextPostalAddress);
        b.setOnClickListener(view -> {
            boolean validFirstName = !TextUtils.isEmpty(firstname.getText());
            boolean validLastName = !TextUtils.isEmpty(lastname.getText());
            boolean validEmail = !TextUtils.isEmpty(email.getText());
            boolean validPhone = !TextUtils.isEmpty(phone.getText());
            boolean validAddress = !TextUtils.isEmpty(address.getText());
            if(!validFirstName){
                firstname.setError("Cannot be left empty!");
            }
            if(!validLastName){
                lastname.setError("Cannot be left empty!");
            }
            if(!validEmail){
                email.setError("Cannot be left empty!");
            }
            if(!validPhone){
                phone.setError("Cannot be left empty!");
            }
            if(!validAddress){
                address.setError("Cannot be left empty!");
            }
            if(validAddress && validEmail && validFirstName && validLastName && validPhone) {
                Intent intent = new Intent(Registration.this, Registration2.class);
                String fname = firstname.getText().toString();
                String lname = lastname.getText().toString();
                String email1 = email.getText().toString();
                String phone1 = phone.getText().toString();
                String address1 = address.getText().toString();
                Bundle b1 = new Bundle();
                b1.putString("fname",fname);
                b1.putString("lname",lname);
                b1.putString("email1",email1);
                b1.putString("phone1",phone1);
                b1.putString("address1",address1);
                intent.putExtras(b1);
                startActivity(intent);
            }
        });
    }
}