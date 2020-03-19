package Comparable;

import java.util.Arrays;
import java.util.Collections;

/**
 * Copyright (C), 2020-2020, XXX有限公司
 * FileName: Worker
 * Author:   cakin
 * Date:     2020/3/19 10:26
 * Description: 工人类
 */
public class Worker implements Comparable<Worker> {
    private String name;
    private int age;
    private int salary;

    public Worker( String name, int age, int salary ) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    /**
     * 实现Comparable接口的compareTo方法，在此方法中定义自己的比较规则 首先按工资有由低到高排序，当工资相同则按年龄由高到底排序
     */
    @Override
    public int compareTo( Worker other ) {
        // TODO Auto-generated method stub
        if (this.salary < other.getSalary()) { // 工资小于其他人时返回负值
            return -1;
        } else if (this.salary > other.getSalary()) { // 工资大于其他人时返回正值
            return 1;
        } else { // 工资等于其他人时按照年龄再排序
            if (this.age < other.getAge()) {
                return 1;// 表示由高到低排序
            } else if (this.age >= other.getAge()) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name + "\t" + this.age + "\t" + this.salary;
    }


    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        Worker[] workers = new Worker[5];
        workers[0] = new Worker("test1", 25, 2000);
        workers[1] = new Worker("test2", 24, 2100);
        workers[2] = new Worker("test3", 26, 2100);
        workers[3] = new Worker("test4", 27, 2200);
        workers[4] = new Worker("test5", 28, 1900);

        //调用Arrays.sort()方法进行排序
        Collections.sort(Arrays.asList(workers));
        for (Worker w : workers) {
            System.out.println(w);
        }
    }
}
