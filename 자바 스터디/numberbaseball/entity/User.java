package com.numberbaseball.entity;

import java.util.List;

public class User extends Player{
    public User() {
        
    }
    private int life;
    
    public User(List<String> numberList,int life) {
        super(numberList);
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

}
