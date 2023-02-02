package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText usernamefield = findViewById(R.id.username);
                EditText emailfield = findViewById(R.id.email);
                EditText passwordfield = findViewById(R.id.password);
                EditText confirmpasswordfield = findViewById(R.id.confirmpassword);

                RadioButton r_man = findViewById(R.id.r_man);
                RadioButton r_woman = findViewById(R.id.r_woman);

                String username = usernamefield.getText().toString();
                String email = emailfield.getText().toString();
                String password = passwordfield.getText().toString();
                String confirmpassword = confirmpasswordfield.getText().toString();

                if(username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmpassword.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(),"Field Can't Be empty",Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(MainActivity.this,Login.class);

                    intent.putExtra("username",username);
                    intent.putExtra("password",password);
                    intent.putExtra("email",email);

                    startActivity(intent);
                }

            }
        });
        View signup = findViewById(R.id.login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Login.class);
                startActivity(intent);
            }
        });

    }
}