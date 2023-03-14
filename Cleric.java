package com.ckm.game;

import java.util.Random;

public class Cleric {
    String name;
    int hp;
    static final int MAX_HP = 50;
    int mp;
    static final int MAX_MP = 10;

    Cleric(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    Cleric(String name, int hp) {
        this(name, hp, MAX_MP);
    }

    Cleric(String name) {
        this(name, MAX_HP, MAX_MP);
    }


    void selfAid() {
        this.mp = mp - 5;
        this.hp = MAX_HP;
    }

    int pray(int seconds) {
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
