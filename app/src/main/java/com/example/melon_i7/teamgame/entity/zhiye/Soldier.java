package com.example.melon_i7.teamgame.entity.zhiye;


import com.example.melon_i7.teamgame.entity.Person;
import com.example.melon_i7.teamgame.entity.wuqi.Broadsword;

/**
 * Created by user on 2016/12/1.
 */

public class Soldier extends Person {

    public Soldier() {}

    public Soldier(int icon, String name, int attack) {
        super(icon, name, attack);
    }

    @Override
    public int getAttack() {
        int _Attack=super.getAttack();
        if(getWeapon()!=null)
        {
            if (getWeapon() instanceof Broadsword){
                _Attack=(_Attack+getWeapon().getAttack())*2;
            }else{
                _Attack=_Attack+getWeapon().getAttack();
            }
        }
        return _Attack;
    }

    @Override
    public  boolean WeaponOk(){
        if(getWeapon()!=null && getWeapon()instanceof Broadsword) {
            return true;
        }else {
            return  false;
        }
    }
}
