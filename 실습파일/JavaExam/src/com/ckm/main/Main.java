package com.ckm.main;

import java.util.List;
import com.ckm.game.Student;
import com.ckm.logics.Asset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class StudentIdAscComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }

} // student 규칙을 정의한 클래스


class StudentIdDscComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getId(), o2.getId()) * -1;
    }

} // student 규칙을 정의한 클래스


class StudentNameAscComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());  //collections 에서 찾은 구문
    }

} // student 규칙을 정의한 클래스


public class Main {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();
        students.add(new Student(0, "이동학"));
        students.add(new Student(3, "최유림"));
        students.add(new Student(1, "박경덕"));
        students.add(new Student(2, "강태근"));


        students.sort(new StudentIdDscComparator()); // 1
        students.sort(new Comparator<Student>() { // 2

            @Override
            public int compare(Student o1, Student o2) {

                return o1.getName().compareTo(o2.getName());
            }

        });

        Collections.sort(students);

        System.out.println(students);



    }
}
