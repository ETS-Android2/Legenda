package com.example.legenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;

public class SettingsScreen extends AppCompatActivity {
    private AudioManager audioManager;
    private SeekBar toggleVolume;
    private double normalVolume;
    private int maxVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        toggleVolume = findViewById(R.id.toggleSound);
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        toggleVolume.setMax(maxVolume);
        normalVolume = 0.3 * (double)maxVolume;
        toggleVolume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        toggleVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void VolumeOn(View view){
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,(int)normalVolume,AudioManager.FLAG_PLAY_SOUND);
        toggleVolume.setProgress((int)normalVolume);
    }
    public void VolumeOff(View view){
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,0,AudioManager.FLAG_PLAY_SOUND);
        toggleVolume.setProgress(0);
    }
    public void backToMain(View view){ //MoveLayout to MainMenu
        Intent intent = new Intent(SettingsScreen.this, MainMenu.class);
        startActivity(intent);
    }
}