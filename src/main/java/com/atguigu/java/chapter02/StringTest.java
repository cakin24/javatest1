package com.atguigu.java.chapter02;

public class StringTest {
    static {
        System.out.println("我是自定义的StringTest类的静态代码块");
    }
    public static void main(String[] args) {
        String str = new String();
        System.out.println("hello");

        StringTest test =new StringTest();
        System.out.println(test.getClass().getClassLoader());
    }
}
