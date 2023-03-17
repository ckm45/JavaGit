package com.ckm.game;

import java.util.Random;

public class Cleric {
    private String name;
    private int hp;
    public static final int MAX_HP = 50;
    private int mp;
    public static final int MAX_MP = 10;

    public Cleric(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    public Cleric(String name, int hp) {
        this(name, hp, MAX_MP);
    }

    public Cleric(String name) {
        this(name, MAX_HP, MAX_MP);
    }


    public void selfAid() {
        this.mp = mp - 5;
        this.hp = MAX_HP;
    }

    public int pray(int seconds) {
        int recovery = seconds + new Random().nextInt(3);
        if (recovery + this.mp > Cleric.MAX_MP) {
            recovery = Cleric.MAX_MP - this.mp;
            this.mp = Cleric.MAX_MP;
        } else {
            this.mp = this.mp + recovery;
        }
        return recovery;
    }
}
