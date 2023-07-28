package com.example.studenthustle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SQLiteDatabase db = openOrCreateDatabase("StudentHustle",MODE_PRIVATE,null);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button2);
        Button c = findViewById(R.id.button);
        EditText username = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword2);
        b.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Registration.class);
            startActivity(intent);
        });
        c.setOnClickListener(view -> {
            boolean validUsername = !TextUtils.isEmpty(username.getText());
            boolean validPassword = !TextUtils.isEmpty(password.getText());
            if(!validUsername){
                username.setError("Please enter your username!");
            }
            if(!validPassword){
                password.setError("Please enter your password!");
            }
            if(validUsername && validPassword) {
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();
                Cursor resultSet = db.rawQuery("Select username, password from Student where username = '"+username1+"' and password = '"+password1+"'  ",null);
                Integer count = resultSet.getCount();
                if(count>0){
                    Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    Bundle b1=new Bundle();
                    b1.putString("username",username1);
                    intent.putExtras(b1);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}