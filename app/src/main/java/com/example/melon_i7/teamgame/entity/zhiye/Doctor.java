package com.example.melon_i7.teamgame.entity.zhiye;


import com.example.melon_i7.teamgame.entity.Person;
import com.example.melon_i7.teamgame.entity.wuqi.Bigsward;

/**
 * Created by user on 2016/12/1.
 */

public class Doctor extends Person {

    public Doctor(){}

    public Doctor(int icon, String name, int attack) {
        super(icon, name, attack);
    }

    @Override
    public int getAttack() {
        int _Attack=super.getAttack();
        if(getWeapon()!=null)
        {
            if (getWeapon() instanceof Bigsward){
                _Attack=(_Attack+getWeapon().getAttack())*2;
            }else{
                _Attack=_Attack+getWeapon().getAttack();
            }
        }
        return _Attack;
    }

    @Override
    public  boolean WeaponOk(){
    if(getWeapon()!=null && getWeapon()instanceof Bigsward) {
        return true;
    }else {
        return  false;
    }
    }
}
