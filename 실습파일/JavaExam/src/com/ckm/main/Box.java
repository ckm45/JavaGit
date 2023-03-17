package com.ckm.main;

public class Box {

    public static void main(String[] args) {
        StrongBox<Integer> sb = new StrongBox<>(KeyType.BUTTON);
        // object로 받지 않으려 하나로 받으려고 제네릭 사용했다

        sb.put(100000);
        System.out.println(sb.get());

        for (int i = 0; i < 10001; i++) {
            sb.get();
        }
        System.out.println(sb.get());

    }

}
