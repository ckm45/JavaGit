package com.numberbaseball.view;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자야구 게임을 시작합니다.");
      //컴퓨터 숫자를 받아오는 메소드
        while(true) {
            
            System.out.printf("숫자를 입력해 주세요: ");
            String count = scanner.nextLine();
            //컴퓨터숫자랑 플레이어 숫자 비교하는 메소드 (계산메소드)
            
            //조건문 사용해서 틀리면 결과 출력 (틀렸을때 출력 메소드)
            //맞으면 게임 맞았다 결과 출력 그 후 새로할 건 지 끝낼건지 판별 (맞았을 때 출력 메소드)
            
        }
    }

}
