package com.itheima.pattern.iterator;

/**
 * @version v1.0
 * @ClassName: Student
 * @Description: 学生类
 * @Author: cakin
 */
public class Student {
    /**
     * 姓名
     */
    private String name;
    /**
     * 学号
     */
    private String number;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Student() {
    }
}
