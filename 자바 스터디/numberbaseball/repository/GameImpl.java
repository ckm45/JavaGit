package com.numberbaseball.repository;

import java.util.List;
import java.util.Random;
import com.numberbaseball.entity.Computer;
import com.numberbaseball.entity.User;


public class GameImpl implements GameRepository {

    int countStrike = 0;
    int countBall = 0;
    
    @Override
    public void makeAnswer(Computer computer) {
        Random random = new Random();

        // 첫 번째 숫자 넣기
        int firstrandomNumber = random.nextInt(9) + 1;
        computer.getNumberList().add(Integer.toString(firstrandomNumber));

        // 두 번째부터 숫자 넣기
        for (int i = 0; i < 2; i++) {
            int randomNumber = random.nextInt(10);
            computer.getNumberList().add(Integer.toString(randomNumber));
        }
    }

    // 다 생성하고 중복된게 있으면 다시 숫자 만들기
    @Override
    public void check(Computer computer) {
        if (!(computer.getNumberList().get(0).equals(computer.getNumberList().get(1)))
                && !(computer.getNumberList().get(0).equals(computer.getNumberList().get(2)))
                && !(computer.getNumberList().get(1).equals(computer.getNumberList().get(2)))) {
            
        } else {
            makeAnswer(computer);
        }

    }

    @Override
    public void calculate(Computer computer, User user) {

        List<String> userNumber = user.getNumberList();
        List<String> comNumber = computer.getNumberList();

        // 123 user
        // 421 computer

        for (String usr : userNumber) {
            for (String com : comNumber) {
                if (usr.equals(com)) {
                    if (userNumber.indexOf(usr) == comNumber.indexOf(com)) {
                        countStrike++;
                    } else {
                        countBall++;
                    }
                }
            }
        }
        
        if(countStrike == 3) {
            win();
        }
        else if(countStrike == 0 && countBall == 0) {
            System.out.println("낫싱");
        }
        else{
            System.out.printf("%d볼 %d 스트라이크", countBall, countStrike);
            
        }
        
        
    }


    @Override
    public void win() {


    }

    @Override
    public void lose() {


    }



}
