package com.ckm.main;

import java.util.Scanner;

public class Silent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int R = sc.nextInt();
        int N = sc.nextInt();

        String answer = "";

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (Math.pow(x - a, 2) + Math.pow(y - b, 2) >= Math.pow(R, 2)) {
                answer = answer + "silent ";
            } else {
                answer = answer + "noisy ";
            }

        }
        String splitedAnswer[] = answer.split(" ");
        for (String ans : splitedAnswer) {
            System.out.println(ans);
        }
    }
}