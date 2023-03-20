package com.ckm.aaa;

import java.util.Objects;

public class Tree extends Map {
    private int x;
    private int y;
    
    public Tree(int x, int y) {
        super(x, y);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(x, y);
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
        Tree other = (Tree) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public String toString() {
        return "Tree [x=" + x + ", y=" + y + "]";
    }





}