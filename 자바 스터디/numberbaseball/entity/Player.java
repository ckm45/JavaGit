package com.numberbaseball.entity;

import java.util.List;

public class Player extends Game{

    private int life;
    
    public Player(List<String> numberList,int life) {
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
