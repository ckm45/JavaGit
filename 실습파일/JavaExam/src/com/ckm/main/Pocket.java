package com.ckm.main;

import java.util.Objects;

public class Pocket <T> {
    public static void main(String[] args) {  //static 이라 Pocket 안에 있다해도 상관 업삳
        Pocket<String> pocket = new Pocket<String>();
        pocket.setData("박경덕");
        
        
        
        
    }
 
    
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pocket other = (Pocket) obj;
        return Objects.equals(data, other.data);
    }

    @Override
    public String toString() {
        return "Pocket [data=" + data + "]";
    }
    

}
