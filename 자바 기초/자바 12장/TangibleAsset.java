package com.ckm.logics;

public abstract class TangibleAsset extends Asset implements Thing {
    // public TangibleAsset() {}
    private int price;
    private String color;

    public TangibleAsset(String name, int price, String color) {
        super(name);
        this.price = price;
        this.color = color;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    private double weight;

    @Override
    public double getWeight() {

        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;

    }

}
