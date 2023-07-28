package com.example.studenthustle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Preferences2 extends AppCompatActivity {

    Intent myfile;
    TextView path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences2);
        Bundle b5 = getIntent().getExtras();
        String username = b5.getString("username4");
        path = findViewById(R.id.textView26);
        Button upload = findViewById(R.id.button11);
        upload.setOnClickListener(view -> {
            myfile = new Intent(Intent.ACTION_GET_CONTENT);
            myfile.setType("*/*");
            startActivityForResult(myfile, 10);
        });
        Button search = findViewById(R.id.button12);
        search.setOnClickListener(view -> {
            Intent intent = new Intent(Preferences2.this,Result.class);
            Bundle b6 = new Bundle();
            b6.putString("username5",username);
            intent.putExtras(b6);
            startActivity(intent);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path1 = data.getData().getPath();
                    path.setText(path1);
                }
                break;
        }
    }
}