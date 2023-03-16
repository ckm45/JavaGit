package com.ckm.ex;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        BankAccount a = new BankAccount("4649", 1592);
        BankAccount b = new BankAccount(" 4649 ", 1592);

        System.out.println(a);

        if (a.equals(b) == true) {
            System.out.println("같다");
        } else {
            System.out.println("다르다");
        }

    }

}
