package com.example.melon_i7.teamgame.bus;


import com.example.melon_i7.teamgame.R;
import com.example.melon_i7.teamgame.entity.Person;
import com.example.melon_i7.teamgame.entity.zhiye.Doctor;
import com.example.melon_i7.teamgame.entity.zhiye.Master;
import com.example.melon_i7.teamgame.entity.zhiye.Soldier;

import java.util.ArrayList;

/**
 * Created by melon on 2016/12/1.
 */

public class PersonX {
    private ArrayList<Person> mPerson;

    public PersonX() {
        mPerson=new ArrayList<>();
        mPerson.add(new Doctor(R.drawable.doctor,"神思者-SSS",55));
        mPerson.add(new Doctor(R.drawable.doctor,"神思者-SS",50));
        mPerson.add(new Doctor(R.drawable.doctor,"神思者-S",45));
        mPerson.add(new Doctor(R.drawable.doctor,"神思者-A",40));
        mPerson.add(new Doctor(R.drawable.doctor,"神思者-B",35));
        mPerson.add(new Doctor(R.drawable.doctor,"神思者-C",30));
        mPerson.add(new Doctor(R.drawable.doctor,"神思者-D",25));
        mPerson.add(new Doctor(R.drawable.doctor,"神思者-E",20));
        mPerson.add(new Doctor(R.drawable.doctor,"神思者-F",15));

        mPerson.add(new Master(R.drawable.master,"大魔导师-SSS",55));
        mPerson.add(new Master(R.drawable.master,"大魔导师-SS",50));
        mPerson.add(new Master(R.drawable.master,"大魔导师-S",45));
        mPerson.add(new Master(R.drawable.master,"大魔导师-A",40));
        mPerson.add(new Master(R.drawable.master,"大魔导师-B",35));
        mPerson.add(new Master(R.drawable.master,"大魔导师-C",30));
        mPerson.add(new Master(R.drawable.master,"大魔导师-D",25));
        mPerson.add(new Master(R.drawable.master,"大魔导师-E",20));
        mPerson.add(new Master(R.drawable.master,"大魔导师-F",15));

        mPerson.add(new Soldier(R.drawable.soldier,"黑暗君主-SSS",55));
        mPerson.add(new Soldier(R.drawable.soldier,"黑暗君主-SS",50));
        mPerson.add(new Soldier(R.drawable.soldier,"黑暗君主-S",45));
        mPerson.add(new Soldier(R.drawable.soldier,"黑暗君主-A",40));
        mPerson.add(new Soldier(R.drawable.soldier,"黑暗君主-B",35));
        mPerson.add(new Soldier(R.drawable.soldier,"黑暗君主-C",30));
        mPerson.add(new Soldier(R.drawable.soldier,"黑暗君主-D",25));
        mPerson.add(new Soldier(R.drawable.soldier,"黑暗君主-E",20));
        mPerson.add(new Soldier(R.drawable.soldier,"黑暗君主-F",15));
    }

    public ArrayList<Person> getmPerson() {
        return mPerson;
    }

    public int getNum(){return mPerson.size();}
}
