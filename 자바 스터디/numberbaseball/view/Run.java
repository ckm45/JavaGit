package com.numberbaseball.view;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자야구 게임을 시작합니다.");
        while(true) {
            System.out.printf("숫자를 입력해 주세요: ");
            int count = Integer.parseInt(scanner.nextLine());
        }
    }

}
