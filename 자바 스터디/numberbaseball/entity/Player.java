package com.numberbaseball.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> numberList = new ArrayList<>();
    
    public Player() {
        
    }
    
    public Player(List<String> numberList) {
       
        this.numberList = numberList;
    }

    public List<String> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<String> numberList) {
        this.numberList = numberList;
    }
    
    
}
