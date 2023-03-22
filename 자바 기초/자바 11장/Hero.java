package com.ckm.game;

public class Hero {
    // field variable
    // global variable
    // member variable
    // property
    private String name; // field 변수
    private int hp; // 이 쪽 영역이 field
    private Sword sword;

    public static int money;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    Hero(String name, int hp) { // 강제로 반드시 name String 넣어야한다.
        this.name = name; // this는 field name , 우측은 파라미터의 name
        this.hp = hp;
        System.out.println("Hero 생성자");
    }

    Hero() {
        this.name = "noname";
        this.hp = 100;
        //System.out.println("Hero 생성자");
    }

    Hero(String name) {
        this.name = name;
        this.hp = 100;
    }

    Hero(int hp) {
        this.name = "noname";
        this.hp = hp;
    }

    void attack(Kinoko kinoko) {
        System.out.println("공격!!!");
    }

    void run() {
        System.out.println("도망쳤다");
    }

    void sit(int sec) {}

    void slip() {}

    void sleep() {
        hp = 100;
        System.out.println(this.name + "는 잠을 자고 회복했다!");
    }
}

