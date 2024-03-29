package com.atguigu.java.chapter02;


public class ClassInitTest {
    private static int num = 1;
    static {
        num = 2;
        number = 20;
        System.out.println(num);
//        System.out.println(number);  // 报错，非法的前向引用（static只能赋值，不能调用）
    }

    private static int number = 10; // linking 中的 prepare：num = 0 --> initial ：20 --> 10

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num); // 2
        System.out.println(ClassInitTest.number); // 10
    }
}
