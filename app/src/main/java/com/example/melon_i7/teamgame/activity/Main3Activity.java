package com.example.melon_i7.teamgame.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.melon_i7.teamgame.R;

public class Main3Activity extends AppCompatActivity {
    private Button mBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIn=new Intent();
                mIn.setClass(Main3Activity.this,MainActivity.class);
                startActivity(mIn);
                finish();
            }
        });
    }

    private void init() {
        mBt= (Button) findViewById(R.id.c_bt1);
    }
}
