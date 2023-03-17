package com.ckm.game;

public abstract class Character {
    String name;
    int hp;

    public abstract void attack(Kinoko kinoko);
    // 미구현 할 거면 abstract 붙여라

    public void run() {
        System.out.println("도망쳤다");
    }

}
