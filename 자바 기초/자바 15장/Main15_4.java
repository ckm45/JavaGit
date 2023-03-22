package com.ckm.sample;

import java.io.IOException;

public class Main15_4 {

    public static void main(String[] args) {

        try {
            System.out.println("프로그램 시작");
            throw new IOException();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}