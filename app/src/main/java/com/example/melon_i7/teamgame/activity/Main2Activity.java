package com.example.melon_i7.teamgame.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.melon_i7.teamgame.R;
import com.example.melon_i7.teamgame.bus.PersionAdapter;
import com.example.melon_i7.teamgame.bus.PersonX;
import com.example.melon_i7.teamgame.bus.Team;
import com.example.melon_i7.teamgame.bus.Yewu;
import com.example.melon_i7.teamgame.entity.Person;
import com.example.melon_i7.teamgame.utilis.Gongju;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private RelativeLayout mR1,mR2,mR3,mR4;
    private ImageView mI1,mI2,mI3,mI4,mI5;
    private ListView mL1;
    private TextView mT1,t1;
    private EditText mEdit;
    private int mItem;
    private ArrayList<Person> mData;
    private PersionAdapter mAdapter;
    private PersonX mPerson;
    private Team mTeam=Team.getDUIWU();
    private Button mButton,mButton1;
    private ProgressBar p1;
    private int mxa=Gongju.R_time;
    private Yewu mY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        mPerson=new PersonX();
        mData=mPerson.getmPerson();
        mItem=R.layout.item_person;
        mAdapter=new PersionAdapter(this,mItem,mData);
        mL1.setAdapter(mAdapter);
        mL1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person _person=mData.get(position);
                mTeam.addPerson(_person);
                UI();
                if(Team.getDUIWU().TeamCont()==4)
                    return;
                mData.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });
        new Time().execute();

    }

    @Override
    protected void onResume() {
        super.onResume();
        UI();
        mT1.setText("攻击力:"+mTeam.sum());
    }

    private void UI() {
        for(int i=0;i<mTeam.TeamCont();i++){
            Person _person=mTeam.getPerson(i);
            if (_person!=null){
                switch (i){
                    case 0:
                        mR1.setOnClickListener(new RLListener());
                        update(_person,mR1,mI1);
                        mR1.setClickable(true);
                        break;
                    case 1:
                        mR2.setOnClickListener(new RLListener());
                        update(_person,mR2,mI2);
                        mR2.setClickable(true);
                        break;
                    case 2:
                        mR3.setOnClickListener(new RLListener());
                        update(_person,mR3,mI3);
                        mR3.setClickable(true);
                        break;
                    case 3:
                        mR4.setOnClickListener(new RLListener());
                        update(_person,mR4,mI4);
                        mR4.setClickable(true);
                        break;
                }
            }
        }
    }


    private void init() {
        mR1= (RelativeLayout) findViewById(R.id.RL_1);
        mR2= (RelativeLayout) findViewById(R.id.RL_2);
        mR3= (RelativeLayout) findViewById(R.id.RL_3);
        mR4= (RelativeLayout) findViewById(R.id.RL_4);
        mI1= (ImageView) findViewById(R.id.image_1);
        mI2= (ImageView) findViewById(R.id.image_2);
        mI3= (ImageView) findViewById(R.id.image_3);
        mI4= (ImageView) findViewById(R.id.image_4);
        mI5= (ImageView) findViewById(R.id.imageView);
        mL1= (ListView) findViewById(R.id.list_1);
        mT1= (TextView) findViewById(R.id.text_2);
        t1=(TextView)findViewById(R.id.text_1);
        mEdit=(EditText)findViewById(R.id.ed1);
        mButton=(Button)findViewById(R.id.bt1);
        mButton1= (Button) findViewById(R.id.bt2);
        p1=(ProgressBar)findViewById(R.id.p1);
        p1.setMax(Gongju.R_time);
        Intent a=getIntent();
        /*if (a!=null){
            int x=a.getIntExtra(Gongju.R_LEVEL,50);

            mY=new Yewu(x);
        }
        t1.setText(mY.getTITLE());*/
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _Input = mEdit.getText().toString();
                try {
                    int _IputN=Integer.parseInt(_Input);
                    String _Result=mY.bijiao(_IputN);
                    if(_Result.equals(Yewu.R_WIN)){
                        setResult(Gongju.RU_WIN);
                        mTeam.teamDelete();
                        finish();
                    }
                    else
                        t1.setText(_Result);
                    mEdit.setText(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ;
            }
        });
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mI5.setBackgroundResource(R.drawable.attack_bg);
                AnimationDrawable an=(AnimationDrawable)mI5.getBackground();
                if(an.isRunning()){
                    an.stop();
                }else{
                    an.start();
                }
            }
        });
    }



    private class RLListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent _Intent =new Intent();
            _Intent.setClass(Main2Activity.this,Main4Activity.class);
            switch (v.getId()){
                case R.id.RL_1:
                    _Intent.putExtra("person",0);
                    break;
                case R.id.RL_2:
                    _Intent.putExtra("person",1);
                    break;
                case R.id.RL_3:
                    _Intent.putExtra("person",2);
                    break;
                case R.id.RL_4:
                    _Intent.putExtra("person",3);
                    Intent a=getIntent();
                    if (a!=null){
                        int x=Gongju.R_max-mTeam.sum();

                        mY=new Yewu(x);
                    }
                    t1.setText(mY.getTITLE());
                    break;
            }
            startActivity(_Intent);
        }
    }

    private void update(Person mP,RelativeLayout mR,ImageView fire){
        mR.setBackgroundResource(mP.getIcon());
        if (mP.WeaponOk()){
            fire.setVisibility(View.VISIBLE);
        }else
            fire.setVisibility(View.INVISIBLE);
    }

    private class Time extends AsyncTask<Void,Integer,String>{
        @Override
        protected String doInBackground(Void... params) {
            for(int i=0;i<mxa;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            Log.i("MyLog","结束循环");
            return Yewu.R_LOSE;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            p1.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            setResult(Gongju.RU_FULL);
            mTeam.teamDelete();
            finish();
        }
    }
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mxa = 0;
    }

}
