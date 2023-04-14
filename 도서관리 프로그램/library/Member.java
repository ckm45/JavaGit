package com.ckm.library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Member implements Comparable<Member>{

    private int memberId; // id
    private String name; // 이름
    private String address; // 주소
    private String phoneNumber; // 연락처
    private String startDay;// 가입한 날짜
    private String birthday; // 생일
    

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");


    public Member(int memberId, String name, String address, String phoneNumber, String startDay,
            String birthday) {

        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.startDay = startDay;
        this.birthday = birthday;
    }



    @Override
    public String toString() {
        return "Member [memberId=" + memberId + ", name=" + name + ", address=" + address
                + ", phoneNumber=" + phoneNumber + ", startDay=" + startDay + ", birthday="
                + birthday + "]";
    }



    public int getMemberId() {
        return memberId;
    }



    public void setMemberId(int memberId) {
        this.memberId = memberId;
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



    public String getStartDay() {
        return startDay;
    }



    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }



    public String getBirthday() {
        return birthday;
    }



    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }



    @Override
    public int hashCode() {
        return Objects.hash(address, birthday, memberId, name, phoneNumber, startDay);
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        return Objects.equals(address, other.address) && Objects.equals(birthday, other.birthday)
                && Objects.equals(memberId, other.memberId) && Objects.equals(name, other.name)
                && Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(startDay, other.startDay);
    }



    @Override
    public int compareTo(Member m) {
        //삭제 할 시에 id 꼬이지 않기 위해 순서를 id 기준으로 오름차순한다
        return this.memberId - m.getMemberId();
    }



}
