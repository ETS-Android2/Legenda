package com.example.legenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GameScreenDuryuOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen_duryu_over);
    }
    public void goBack(View view){//MoveLayout to next GameScreen c2
        Intent intent = new Intent(GameScreenDuryuOver.this, MainMenu.class);
        startActivity(intent);
    }
}