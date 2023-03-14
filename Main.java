package com.ckm.main;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();

        person1.name = "홍길동";
        person2.name = "한석봉";

        ArrayList<String> personList = new ArrayList<>();
        personList.add(person1.name);
        personList.add(person2.name);
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }


    }
}
