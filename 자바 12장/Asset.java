package com.ckm.logics;

public abstract class Asset {
    private String name;


    public Asset(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
