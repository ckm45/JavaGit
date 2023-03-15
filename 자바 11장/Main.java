package com.ckm.game;

public class Main {

    public static void main(String[] args) {
        Hero hero = new Hero();
        PoisonKinoko poisonKinoko = new PoisonKinoko('A');
        for (int i = 0; i < 5; i++) {
            poisonKinoko.attack(hero);
        }
    }
}
