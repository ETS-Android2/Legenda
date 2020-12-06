package com.example.legenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TheEnd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_end);
    }
    public void goBack(View view){//MoveLayout to next GameScreen c2
        Intent intent = new Intent(TheEnd.this, MainMenu.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {

    }
}