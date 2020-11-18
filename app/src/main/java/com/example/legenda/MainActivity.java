package com.example.legenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private final int splashTime=2000; // splash Screen time interval

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() { //code to convert MainActivity to splash screen
            @Override
            public void run() {
                Intent home=new Intent(MainActivity.this, MainMenu.class);
                startActivity(home);
                finish();
            }
        },splashTime);
    }
}