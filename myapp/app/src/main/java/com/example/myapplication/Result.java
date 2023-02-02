package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        float height = getIntent().getExtras().getFloat("height")/100;
        float weight = getIntent().getExtras().getFloat("weight");
        View bg = findViewById(R.id.result);
        TextView tvimc = findViewById(R.id.imc);

        String msg = " Your imc is ";
        float imc = weight / (height*height);

        if(imc < 18){
            bg.setBackgroundColor(Color.RED);
            tvimc.setText(msg + imc +" Insuffisance pondérale (maigreur)" );
        }
        if(imc > 18 && imc < 25){
            bg.setBackgroundColor(Color.GREEN);
            tvimc.setText(msg + imc +" Corpulence normale" );
        }
        if(imc > 25 && imc < 30){
            bg.setBackgroundColor(Color.YELLOW);
            tvimc.setText(msg + imc +" Surpoids" );
        }
        if(imc > 30 && imc < 35){
            bg.setBackgroundColor(Color.rgb(128,0,0));
            tvimc.setText(msg + imc +" Obésité modérée" );
        }
        if(imc > 35 && imc < 40){
            //bg.setBackgroundColor(Color.parseColor("FFDF892E"));
            tvimc.setText(msg + imc +" Obésité sévère" );
        }
        if( imc > 40){
            bg.setBackgroundColor(Color.RED);
            tvimc.setText(msg + imc +" Obésité morbide ou massive" );
        }
    }
}