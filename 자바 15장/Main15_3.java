package com.ckm.sample;

public class Main15_3 {

    public static void main(String[] args) {
        try {
            int i = Integer.parseInt("Three");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException 예외를 catch하였습니다");
            e.printStackTrace();
        }

    }
}