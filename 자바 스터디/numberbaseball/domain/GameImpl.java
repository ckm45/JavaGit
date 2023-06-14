package com.numberbaseball.domain;

import java.util.Random;
import com.numberbaseball.entity.Computer;
import com.numberbaseball.entity.Game;

public class GameImpl implements GameRepository {


    @Override
    public void makeAnswer(Game game) {
        Random random = new Random();

        // 첫 번째 숫자 넣기
        int firstrandomNumber = random.nextInt(9) + 1;
        game.getNumberList().add(Integer.toString(firstrandomNumber));

        // 두 번째부터 숫자 넣기
        for (int i = 0; i < 2; i++) {
            int randomNumber = random.nextInt(10);
            game.getNumberList().add(Integer.toString(randomNumber));
        }
    }

    //다 생성하고 중복된게 있으면 다시 숫자 만들기 
    @Override
    public void check(Game game) {
        game.getNumberList()
        // TODO Auto-generated method stub

    }

    @Override
    public void calculate(Game game) {
        // TODO Auto-generated method stub

    }

    @Override
    public void win() {
        // TODO Auto-generated method stub

    }

    @Override
    public void lose() {
        // TODO Auto-generated method stub

    }



}
