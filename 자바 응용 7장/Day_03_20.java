package com.ckm.sample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1113215L;
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


class Department implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1154865L;
    String name;
    Employee leader;

    public Department(Employee leader, String name) {
        this.leader = leader;
        this.name = name;
    }
}


public class Day_03_20 {
    public static void main(String[] args) throws Exception {
        Department department = new Department(new Employee("홍길동", 41), "총무부");

        FileOutputStream fos = new FileOutputStream("company.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(department);
        oos.flush();
        oos.close();


    }

}
