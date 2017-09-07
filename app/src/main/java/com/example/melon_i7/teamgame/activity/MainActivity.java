package com.example.melon_i7.teamgame.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.melon_i7.teamgame.R;
import com.example.melon_i7.teamgame.bus.Yewu;
import com.example.melon_i7.teamgame.service.MusicService;
import com.example.melon_i7.teamgame.utilis.Gongju;

public class MainActivity extends AppCompatActivity {
    private Button B1,B2;
    private ImageView I1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent mInten=new Intent(MainActivity.this, MusicService.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(mInten);
        init();
        B1.setOnClickListener(new BUTTON());
        B2.setOnClickListener(new BUTTON());

    }


    private void init() {
        B1=(Button) findViewById(R.id.a_bt1);
        B2=(Button) findViewById(R.id.a_bt2);
        I1=(ImageView)findViewById(R.id.a_image);
    }

    private  class BUTTON implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.a_bt1:
                    Intent INT=new Intent();
                    //INT.putExtra(Gongju.R_LEVEL, Yewu.LEVEL_a);
                    INT.setClass(MainActivity.this,Main2Activity.class);
                    startActivityForResult(INT,Gongju.R_START);
                    break;
                case R.id.a_bt2:
                    Intent Int=new Intent();
                    Int.setClass(MainActivity.this,Main3Activity.class);
                    startActivity(Int);
                    break;
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==Gongju.R_START){
            if (resultCode==Gongju.RU_WIN){
                I1.setImageResource(R.drawable.a4);
            }
            if (resultCode==Gongju.RU_FULL){
                I1.setImageResource(R.drawable.a3);
            }
        }
    }

    @Override
    protected void onStop() {
        Intent mInten=new Intent(MainActivity.this, MusicService.class);
        // stopService(mInten);
        super.onStop();
    }
}
