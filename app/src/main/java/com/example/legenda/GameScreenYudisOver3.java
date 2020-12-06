package com.example.legenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameScreenYudisOver3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen_yudis_over3);
    }
    public void goBack(View view){//MoveLayout to next GameScreen c2
        Intent intent = new Intent(GameScreenYudisOver3.this, MainMenu.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {

    }
}