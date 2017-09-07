package com.example.melon_i7.teamgame.bus;

import java.util.Random;

/**
 * Created by melon_i7 on 2017/5/31.
 */

public class Yewu {
    private int randomNum;
    public static final int LEVEL_a=50;
    public static final String R_WIN="win";
    public static final String R_LOSE="lose";
    private  String TITLE;

    public Yewu(int RAN) {
        randomNum=new Random().nextInt(RAN);
        TITLE="请输入：0-"+RAN+"的倍率";
    }
    public String bijiao(int pIn){
        if(pIn>randomNum)
            return  "猜的倍率大了！";
        else if (pIn<randomNum)
            return "猜的倍率小了！";
        else
            return R_WIN;
    }

    public String getTITLE() {
        return TITLE;
    }
}
