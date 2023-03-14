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
        if (hp < 0) {
            this.hp = 0;
        }
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        if (mp < 0) {
            throw new IllegalArgumentException("마법사의 MP는 0 이상이어야 한다.");
        }

        this.mp = mp;
    }

    public String getName() {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null이 아니어야 한다");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("이름은 반드시 3문자 이상이어야 한다");
        }


        return name;

    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        if (wand == null) {
            throw new IllegalArgumentException("마법사의 지팡이는 null일 수 없다.");
        }

        this.wand = wand;
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
