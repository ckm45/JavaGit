package com.ckm.eee;

public class Utils {

    interface Func1 {
        public abstract boolean callOdd(int a);
    }
    interface Func2 {
        public abstract String addNamePrefix(boolean male, String name);
    }

    public static boolean isOdd(int n) {
        return n % 2 == 1;
    }

    public static String addNamePrefix(boolean male, String name) {
        if (male == true) {
            return "Mr." + name;
        }
        return "Ms." + name;
    }

    public static void main(String[] args) {
        Func1 func1 = a -> a % 2 == 1;
        Func2 func2 = (male, name) -> {
            if (male == true) {
                return "Mr." + name;
            }
            return "Ms." + name;
        };

        boolean result1 = func1.callOdd(15);
        System.out.println(result1);

        String result2 = func2.addNamePrefix(false, "홍길동");
        System.out.println(result2);


    }
}
