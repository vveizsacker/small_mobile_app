package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        String session_username = getIntent().getExtras().getString("username");
        Toast toast = Toast.makeText(getApplicationContext(),"Welcome "+session_username,Toast.LENGTH_SHORT);
        toast.show();
        TextView tvusername = findViewById(R.id.tvusername);
        tvusername.setText(session_username);

        Button calculate = findViewById(R.id.submit);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText heightfield = findViewById(R.id.height);
                EditText weightfield = findViewById(R.id.weight);
                EditText agefield = findViewById(R.id.age);

                float height = Float.parseFloat(heightfield.getText().toString());
                float weight = Float.parseFloat(weightfield.getText().toString());
                int age = Integer.parseInt(agefield.getText().toString());

                Intent intent = new Intent(Profile.this , Result.class);

                intent.putExtra("height",height);
                intent.putExtra("weight",weight);

                startActivity(intent);
            }
        });
        Button logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this , Login.class);
                startActivity(intent);
            }
        });
    }
}