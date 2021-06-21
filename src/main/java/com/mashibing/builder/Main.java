package com.mashibing.builder;

/**
 * @author: Yuanzt
 * @Date: 2021/3/18
 */
public class Main {

    public static void main(String[] args) {
        Person p = new Person.PersonBuilder()
                .basicInfo(1,"张三",18)
                .score(20)
                .weight(180)
                .loc(new Location("长江西路","100"))
                .build();
        System.out.println(p);
    }
}
