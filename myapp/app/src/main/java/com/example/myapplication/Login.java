package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String session_username = "test";
        String session_password = "test";

        if(getIntent().getExtras() != null){
            session_username= getIntent().getExtras().getString("username");
            session_password= getIntent().getExtras().getString("password");
        }

        setContentView(R.layout.activity_login);
        Button button = findViewById(R.id.login);

        String finalSession_username = session_username;
        String finalSession_password = session_password;

        Toast toast = Toast.makeText(getApplicationContext(),finalSession_username +" "+ finalSession_password,Toast.LENGTH_SHORT);
        toast.show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText usernamefield = findViewById(R.id.username);
                EditText passwordfield= findViewById(R.id.password);

                String username = usernamefield.getText().toString();
                String password = passwordfield.getText().toString();

                if(username == "" || username.isEmpty() || password == "" || password.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(),"Username and Password Can't be empty",Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    if(!username.equals(finalSession_username) || !password.equals(finalSession_password)){
                        Toast toast = Toast.makeText(getApplicationContext(),"Username or Password is Wrong !",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    if(username.equals(finalSession_username) && password.equals(finalSession_password)){
                        Intent intent = new Intent(Login.this , Profile.class);

                        intent.putExtra("username",username);
                        intent.putExtra("password",password);

                        startActivity(intent);
                    }
                }
            }
        });

        View signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this , MainActivity.class);
                startActivity(intent);
            }
        });
    };
}