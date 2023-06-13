package com.subway.entity;

public class Vegetable extends Ingredient{
    private int price;
    
    public Vegetable(String name, int calorie, int price) {
        super(name, calorie);
        this.price = price;
       
    }


    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
