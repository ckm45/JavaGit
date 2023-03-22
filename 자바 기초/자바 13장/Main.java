package com.ckm.logics;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Y> list = new ArrayList(); // 타입 Y
        list.add(new A());
        list.add(new B());

        list.get(0).b();
        list.get(1).b();

        for (Y y : list) {
            y.b();
        }
    }
}
