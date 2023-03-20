package com.ckm.aaa;

import java.util.Objects;

public class ConstructionSite extends Map {
    private int a;
    private int b;
    private int noise;


    public ConstructionSite(int a, int b, int noise) {
        super(a, b);
        this.noise = noise;
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getNoise() {
        return noise;
    }

    public void setNoise(int noise) {
        this.noise = noise;
    }

    @Override
    public String toString() {
        return "ConstructionSite [a=" + a + ", b=" + b + ", noise=" + noise + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(a, b, noise);
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConstructionSite other = (ConstructionSite) obj;
        return a == other.a && b == other.b && noise == other.noise;
    }


}