package com.subway.entity;

public class Ingredient {
    private String name;
    private int calorie;

    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", calorie=" + calorie + "]";
    }


    public Ingredient(String name, int calorie) {

        this.name = name;
        this.calorie = calorie;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }


}
