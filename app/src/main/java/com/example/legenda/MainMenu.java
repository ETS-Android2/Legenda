package com.example.legenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void MoveSettings(View view){ //MoveLayout to Settings page
        Intent intent = new Intent(MainMenu.this, SettingsScreen.class);
        startActivity(intent);
    }

    public void MoveCredits(View view){ //MoveLayout to Credits page
        Intent intent = new Intent(MainMenu.this, CreditsScreen.class);
        startActivity(intent);
    }
    public void PlayGame(View view){ //MoveLayout to GameScreenBegin page
        Intent intent = new Intent(MainMenu.this, GameScreenBegin.class);
        startActivity(intent);
    }
}