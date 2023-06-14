package com.subway.entity;

import java.util.Objects;

public class Ingredient {
    private String name;
    private int calorie;

    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", calorie=" + calorie + "]";
    }


    @Override
    public int hashCode() {
        return Objects.hash(calorie, name);
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
