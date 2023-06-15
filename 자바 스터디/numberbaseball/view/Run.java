package com.numberbaseball.view;

import java.util.Scanner;
import com.numberbaseball.entity.Computer;
import com.numberbaseball.entity.User;
import com.numberbaseball.repository.GameImpl;


public class Run {
    public static boolean isExit = false;
    public static boolean comCheck = false;
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자야구 게임을 시작합니다.");
        GameImpl gameImpl = new GameImpl();
        
        //컴퓨터 숫자를 받아오는 메소드
        gameImpl.makeAnswer(computer);
        //리스트 만들고 그걸 set으로 바꿔 그 set 길이가 3이면 맞고 아니면 다시 만들게끔 
        gameImpl.check(computer);
        System.out.println(computer.getNumberList());
      
        while(!isExit) { 
            
            System.out.printf("숫자를 입력해 주세요: ");
            String count = scanner.nextLine();
            gameImpl.convertString(count, user);
            //컴퓨터숫자랑 플레이어 숫자 비교하는 메소드 (계산메소드)
            gameImpl.calculate(computer, user);
            //조건문 사용해서 틀리면 결과 출력 (틀렸을때 출력 메소드)
            //맞으면 게임 맞았다 결과 출력 그 후 새로할 건 지 끝낼건지 판별 (맞았을 때 출력 메소드)
        
        }
    }

}
