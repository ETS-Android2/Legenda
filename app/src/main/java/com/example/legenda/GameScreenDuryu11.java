package com.example.legenda;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GameScreenDuryu11 extends AppCompatActivity {

    HomeWatcher mHomeWatcher;
    GameScreenDuryu10A gs10A = new GameScreenDuryu10A();
    GameScreenDuryu10B gs10B = new GameScreenDuryu10B();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen_duryu11);

        doBindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        startService(music);

        mHomeWatcher = new HomeWatcher(this);
        mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {

            @Override
            public void onHomePressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
            @Override
            public void onHomeLongPressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
        });
        mHomeWatcher.startWatch();
    }

    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon =new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this,MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mServ != null) {
            mServ.resumeMusic();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        PowerManager pm = (PowerManager)
                getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = false;
        if (pm != null) {
            isScreenOn = pm.isScreenOn();
        }

        if (!isScreenOn) {
            if (mServ != null) {
                mServ.pauseMusic();
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        doUnbindService();
        Intent music = new Intent();
        music.setClass(this,MusicService.class);
        stopService(music);
        mHomeWatcher.stopWatch();
    }
    public boolean getBoolean(String key){
        SharedPreferences sp = getApplicationContext().getSharedPreferences("DuryudanaChoices", Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }
    public void selectChoice1(View view){//MoveLayout to MainMeny after game end
        boolean isKresna = getBoolean("isKresna");
        if(isKresna){
            Intent intent = new Intent(GameScreenDuryu11.this, GameScreenDuryu12B.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(GameScreenDuryu11.this, GameScreenDuryu12A.class);
            startActivity(intent);
        }

    }
    @Override
    public void onBackPressed() {

    }
}