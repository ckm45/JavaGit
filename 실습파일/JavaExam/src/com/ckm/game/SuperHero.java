package com.ckm.game;

public class SuperHero extends Hero {
    private boolean flying;
    
    public SuperHero() {
        System.out.println("SuperHero 생성자");
    }

    public void fly() {
        flying = true;
        System.out.println("날았다!");
    }

    public void land() {
        flying = false;
        System.out.println("착지했다!");
    }

    @Override
    public void run() {
        System.out.println("퇴각했다");
    }
    @Override
    public void attack(Kinoko kinoko) {
        System.out.println("준비운동");
        
        super.attack(kinoko);  //super 상속 받은 것 동작 (기존 것)
        
        if(this.flying) {
            System.out.println("추가 공격");
        }
    }
}
