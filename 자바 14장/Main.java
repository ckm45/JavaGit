package com.ckm.ex;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        Calendar calendar = Calendar.getInstance(); // Calendar 추상메소드 여서 new로 못 만든다.
        calendar.setTime(now);

        int day = calendar.get(Calendar.DATE);
        System.out.println(day);

        calendar.set(Calendar.DATE, day + 100);

        Date future = calendar.getTime();

        SimpleDateFormat format = new SimpleDateFormat("서기 yyyy년 MM월 dd일");

        System.out.println(format.format(future)); // 메소드 format()은 return 타입이 String이다

        // calendar.add(Calendar.DATE,100);

    }

}
