package com.ckm.aaa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String answer = "";
        int treeNumbers;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int r = sc.nextInt();

        ConstructionSite constructionSite = new ConstructionSite(a, b, r);
        treeNumbers = sc.nextInt();
        for (int i = 0; i < treeNumbers; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Tree tree = new Tree(x, y);
            if (Math.pow(tree.getX() - constructionSite.getX(), 2)
                    + Math.pow(tree.getY() - constructionSite.getY(), 2) >= Math
                            .pow(constructionSite.getNoise(), 2)) {
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