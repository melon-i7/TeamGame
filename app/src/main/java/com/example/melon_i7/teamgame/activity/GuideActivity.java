package com.example.melon_i7.teamgame.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.melon_i7.teamgame.R;
import com.example.melon_i7.teamgame.bus.ViewPagerAdapter;
import com.example.melon_i7.teamgame.utilis.Gongju;
import com.example.melon_i7.teamgame.utilis.SPUtils;

import java.util.Timer;
import java.util.TimerTask;

public class GuideActivity extends AppCompatActivity {
    ViewPager vpGuideMain;
    private ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        vpGuideMain= (ViewPager) findViewById(R.id.vp_guide_main);
       /*SharedPreferences sharedPreferences=this.getSharedPreferences("share",MODE_PRIVATE);
        boolean isFirstRun=sharedPreferences.getBoolean("isFirstRun",true);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if (isFirstRun){
            editor.putBoolean("isFirstRun",false);
            editor.commit();
            start();
        }else {
            startActivity(new Intent(GuideActivity.this,SplashActivity.class));
        }*/
        boolean isFirst= SPUtils.readBoolean("isFirst");
        if(isFirst){
            SPUtils.writeBoolean("isFirst",false);
            start();
        }else {
            startActivity(new Intent(GuideActivity.this,SplashActivity.class));
            finish();
        }

    }
    protected  void start(){
        adapter=new ViewPagerAdapter();
        vpGuideMain.setAdapter(adapter);
        vpGuideMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private Timer timer;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==adapter.getCount()-1){
                    timer=new Timer(false);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            startActivity(new Intent(GuideActivity.this,SplashActivity.class));
                            finish();
                        }
                    }, Gongju.R_Gtime);
                }else {
                    if(timer!=null)
                        timer.cancel();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
