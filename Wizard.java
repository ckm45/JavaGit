package com.ckm.game;

public class Wizard {
    private int hp;
    private int mp;
    private String name;
    private Wand wand;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void heal(Hero hero) {
        int basePoint = 10; // 기본회복 포인트
        int recovPoint = (int) (basePoint * wand.getPower());
        hero.setHp(hero.getHp() + recovPoint);
    }

}
