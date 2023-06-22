package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity {
    private EditText nameText;
    private EditText ageText;

    private Button next;

    private TextView erorr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameText = findViewById(R.id.editTextName);
        ageText = findViewById(R.id.editTextName);
        next = findViewById(R.id.next);
        erorr = findViewById(R.id.Error);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameText.getText().toString().equals("") || ageText.getText().toString().equals(null)) {
                    erorr.setText("Enter your name and your age");
                } else {
                    SharedPreferences sp = MainActivity.this.getSharedPreferences("main", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    User user = new User(nameText.getText().toString(), 0);
                    editor.putString(user.getName(), nameText.toString());
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);

                }

            }
        });



    }


}