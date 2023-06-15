package com.numberbaseball.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.numberbaseball.entity.Computer;
import com.numberbaseball.entity.User;
import com.numberbaseball.view.Run;


public class GameImpl implements GameRepository {

    int countStrike = 0;
    int countBall = 0;
    //User user = new User();
    @Override
    public void makeAnswer(Computer computer) {
        Random random = new Random();
        List<String> list = new ArrayList<>();
        computer.setNumberList(list);
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
        //makeAnswer(computer);
        //System.out.println(!(computer.getNumberList().get(0).equals(computer.getNumberList().get(1))));
        //System.out.println(!(computer.getNumberList().get(0).equals(computer.getNumberList().get(2))));
//        System.out.println(!(computer.getNumberList().get(1).equals(computer.getNumberList().get(2))));
//        System.out.println(computer.getNumberList().get(0));
//        System.out.println(computer.getNumberList().get(1));
//        System.out.println(computer.getNumberList().get(2));
        
        if (!(computer.getNumberList().get(0).equals(computer.getNumberList().get(1)))
                && !(computer.getNumberList().get(0).equals(computer.getNumberList().get(2)))
                && !(computer.getNumberList().get(1).equals(computer.getNumberList().get(2)))) {
            Run.comCheck = true;
        } else {
            makeAnswer(computer);
        }

    }

    @Override
    public void calculate(Computer computer, User user) {

        List<String> userNumber = user.getNumberList();
        List<String> comNumber = computer.getNumberList();
        
        //System.out.println(comNumber);
        //System.out.println(user.getNumberList());
        
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
            System.out.println("낫싱\n");
            countStrike = 0; 
            countBall = 0;
        }
        else{
            System.out.printf("%d볼 %d 스트라이크\n", countBall, countStrike);
            countStrike = 0;
            countBall = 0;
        }
        
        
    }


    @Override
    public void win() {
        System.out.println("승리하였습니다.");
        Run.isExit = true;
    }

    @Override
    public void lose() {


    }

    @Override
    public void convertString(String number, User user) {
        List<String> list = new ArrayList<>();
        user.setNumberList(list);
        List<String> userNumber = user.getNumberList();
        for(int i = 0; i < number.length(); i++) {            
            userNumber.add(number.substring(i,i+1));
        }
//        System.out.println(userNumber);
        user.setNumberList(userNumber);

    }



}
