package com.numberbaseball.domain;

import java.util.Random;
import com.numberbaseball.entity.Computer;
import com.numberbaseball.entity.Game;

public interface GameRepository {
    
    void makeAnswer(Game game);
    
    void calculate(Game game);

    void win();

    void lose();
    
    void check(Game game);

}