package com.numberbaseball.repository;

import com.numberbaseball.entity.Computer;
import com.numberbaseball.entity.User;

public interface GameRepository {
    
    void makeAnswer(Computer computer);
    
    void calculate(Computer computer, User user);

    void win();

    void lose();
    
    void check(Computer computer);
    
    void convertString(String number, User user);
    
}