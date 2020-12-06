package com.example.legenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameScreenYudisOver1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen_yudis_over1);
    }
    public void goBack(View view){//MoveLayout to next GameScreen c2
        Intent intent = new Intent(GameScreenYudisOver1.this, MainMenu.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {

    }
}