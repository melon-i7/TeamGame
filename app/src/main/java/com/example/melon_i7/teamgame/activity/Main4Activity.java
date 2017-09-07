package com.example.melon_i7.teamgame.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.melon_i7.teamgame.R;
import com.example.melon_i7.teamgame.bus.Team;
import com.example.melon_i7.teamgame.bus.WeaponAdapter;
import com.example.melon_i7.teamgame.bus.WeaponX;
import com.example.melon_i7.teamgame.entity.Person;
import com.example.melon_i7.teamgame.entity.Weapon;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    private Weapon mWeapon;
    private WeaponAdapter mAdapter;
    private ListView mList;
    private int mItem;
    private ArrayList<Weapon> mData;
    private Person mPerson;
    private Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();
    }
    private void init() {
        mList= (ListView) findViewById(R.id.list_2);
        mItem=R.layout.item_weapon;
        mIntent=getIntent();
        mList= (ListView) findViewById(R.id.list_2);
        WeaponX mW=new WeaponX();
        mData=mW.getmWeapon();
        mAdapter=new WeaponAdapter(this,mItem,mData);
        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int a=mIntent.getIntExtra("person",0);
                mPerson= Team.getDUIWU().getPerson(a);
                mWeapon=mData.get(position);
                mPerson.setWeapon(mWeapon);
                finish();
            }
        });
    }
}
