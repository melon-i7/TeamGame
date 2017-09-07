package com.example.melon_i7.teamgame.bus;

import com.example.melon_i7.teamgame.R;
import com.example.melon_i7.teamgame.entity.Weapon;
import com.example.melon_i7.teamgame.entity.wuqi.Bigsward;
import com.example.melon_i7.teamgame.entity.wuqi.Broadsword;
import com.example.melon_i7.teamgame.entity.wuqi.Wand;

import java.util.ArrayList;

/**
 * Created by melon on 2016/12/1.
 */

public class WeaponX {
    private ArrayList<Weapon> mWeapon;

    public WeaponX() {
        mWeapon =new ArrayList<>();
        mWeapon.add(new Broadsword(R.drawable.weapon_01,"屠戮之刃",10));
        mWeapon.add(new Broadsword(R.drawable.weapon_02,"秋叶刀",15));
        mWeapon.add(new Broadsword(R.drawable.weapon_03,"绝刀-红莲天舞",20));
        mWeapon.add(new Broadsword(R.drawable.weapon_04,"黑刀-暗月",25));
        mWeapon.add(new Broadsword(R.drawable.weapon_05,"月之光芒",30));
        mWeapon.add(new Wand(R.drawable.weapon_06,"贤者之杖",10));
        mWeapon.add(new Wand(R.drawable.weapon_07,"智者千虑",15));
        mWeapon.add(new Wand(R.drawable.weapon_08,"童话之森",20));
        mWeapon.add(new Wand(R.drawable.weapon_09,"灾难召唤者",25));
        mWeapon.add(new Wand(R.drawable.weapon_10,"江山略-法杖",30));
        mWeapon.add(new Bigsward(R.drawable.weapon_11,"雷剑-苦轮",10));
        mWeapon.add(new Bigsward(R.drawable.weapon_12,"光炎剑-烈日裁决",15));
        mWeapon.add(new Bigsward(R.drawable.weapon_13,"无影剑-艾雷诺",20));
        mWeapon.add(new Bigsward(R.drawable.weapon_14,"别云剑-无用",25));
        mWeapon.add(new Bigsward(R.drawable.weapon_15,"天丛云",30));
    }

    public ArrayList<Weapon> getmWeapon() {
        return mWeapon;
    }
}
