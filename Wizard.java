package com.ckm.game;

public class Wizard {
    private int hp;
    private int mp;
    private String name;
    private Wand wand;

    public void heal(Hero hero) {
        int basePoint = 10; // 기본회복 포인트
        int recovPoint = (int) (basePoint * this.wand.power);
        hero.setHp(hero.getHp() + recovPoint);
    }

}