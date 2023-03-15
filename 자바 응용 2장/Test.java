package com.ckm.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Test {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();

        person1.name = "홍길동";
        person2.name = "한석봉";

        Map<String, Integer> persons = new HashMap<>();

        persons.put(person1.name, 20);
        persons.put(person2.name, 25);

        Set<String> keySet = persons.keySet();
        for (String key : keySet) {
            System.out.println(key + "의 나이는 " + persons.get(key) + "살");
        }

    }
}
