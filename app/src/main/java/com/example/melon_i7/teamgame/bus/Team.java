package com.example.melon_i7.teamgame.bus;



import com.example.melon_i7.teamgame.entity.Person;

import java.util.ArrayList;

/**
 * Created by melon on 2016/12/1.
 */

public class Team {
    public ArrayList<Person> mTeam;

    public Team() {
        mTeam=new ArrayList<>();
    }

    private static Team DUIWU =new Team();
    public static Team getDUIWU(){return DUIWU;}
    public  int TeamCont(){return mTeam.size();}
    public void addPerson(Person mPerson){
         if (mTeam.size()<4)
         mTeam.add(mPerson);
         else
             return;

    }
    public Person getPerson(int i){return mTeam.get(i);}
    public void teamDelete(){
        mTeam=new ArrayList<>();
    }

    public int sum(){
        int sum=0;
        for(int i=0;i<mTeam.size();i++){
            sum=sum+mTeam.get(i).getAttack();
        }
        return sum;
    }
}

