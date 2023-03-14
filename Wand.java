package com.ckm.game;

public class Wand {
    private String name; // 지팡이의 이름
    private double power; // 지팡이의 마력

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        if (power < 0.5 && power > 100.0) {
            throw new IllegalArgumentException("지팡이의 마력은 0.5 이상 100.0이하여야 한다.");
        }

        this.power = power;
    }
}