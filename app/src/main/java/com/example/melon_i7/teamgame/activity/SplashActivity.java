package com.example.melon_i7.teamgame.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.melon_i7.teamgame.R;
import com.example.melon_i7.teamgame.utilis.Gongju;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    TextView mtext;
    private int counDown= Gongju.R_Stime;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        mtext= (TextView) findViewById(R.id.tv_splash_timer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SplashActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String timerCount=getString(R.string.string_splash_timer);
                        timerCount=String.format(timerCount,--counDown);
                        mtext.setText(timerCount);
                        try{if (counDown==0){
                            Intent mIn=new Intent();
                            mIn.setClass(SplashActivity.this,MainActivity.class);
                            startActivity(mIn);
                            timer.cancel();
                            finish();
                        }}catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }
        },0,1000);
        mtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                timer.cancel();
                finish();
            }
        });

    }
}
