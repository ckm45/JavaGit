package com.ckm.library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Member {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    
    
    private int memberId; // id
    private String name; // 이름
    private String address; // 주소
    private String phoneNumber; // 연락처
    private String startDay;// 가입한 날짜
    private String birthday; // 생일
    private int age;


    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");



    Date date = new Date();

    SimpleDateFormat dateYear = new SimpleDateFormat("yyyy");
    String year = dateYear.format(date);


    public Member(String name, String address, String phoneNumber, String birthday) {

        this.memberId = ID_GENERATOR.getAndIncrement();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public int getMemberId() {
        return memberId;
    }
    
    
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getStartDay() {
        return startDay;
    }


    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




    public String getBirthday() {
        return birthday;
    }


    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Member [memberId=" + memberId + ", name=" + name + ", address=" + address
                + ", phoneNumber=" + phoneNumber + ", startDay=" + startDay + ", birthday="
                + birthday + ", age=" + age + "]";
    }



}
