package com.ckm.sample;

public class Main15_2 {

    public static void main(String[] args) {
        String s = null;;
        try {
            System.out.println(s.length());

        } catch (Exception e) {
            System.out.println("NullPointerException 예외를 catch하였습니다");
            System.out.println("---- stack trace (여기부터) ----");
            e.printStackTrace();
            System.out.println("---- stack trace (여기까지) ----");
        }
    }
}