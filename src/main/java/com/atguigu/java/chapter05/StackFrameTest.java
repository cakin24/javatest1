package com.atguigu.java.chapter05;

/**
 * 1 栈帧
 * 2 Java方法有两种返回函数的方式，一种是正常的函数返回，使用 return 指令；另外一种是抛出异常。不管使用哪种方式，都会导致栈帧被弹出。
 */
public class StackFrameTest {
    // 正常返回
    public static void main(String[] args) {
        try {
            method01();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main方法结束");
    }
    // 抛出异常返回
    public static int method01() {
        System.out.println("方法1的开始");
        int i = method02();
        System.out.println("方法1的结束");
        int k = 10/0;
        return i;
    }
    // 正常返回
    public static int method02() {
        System.out.println("方法2的开始");
        int i = method03();
        System.out.println("方法2的结束");
        return i;
    }
    // 正常返回
    public static int method03() {
        System.out.println("方法3的开始");
        int i = 30;
        System.out.println("方法3的结束");
        return i;
    }
}
