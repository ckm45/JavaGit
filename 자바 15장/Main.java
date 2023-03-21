package com.ckm.sample;

public class Main {

    public static void main(String[] args) {
        String s = null;;
        try {
            System.out.println(s.length());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}