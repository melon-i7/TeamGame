package com.example.melon_i7.teamgame.entity;

/**
 * Created by user on 2016/12/1.
 */

public class Weapon {
    private int icon;
    private String name;
    private int attack;

    public Weapon() {}

    public Weapon(int icon, String name, int attack) {
        this.icon = icon;
        this.name = name;
        this.attack = attack;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
