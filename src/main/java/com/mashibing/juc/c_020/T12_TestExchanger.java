package com.mashibing.juc.c_020;

import java.util.concurrent.Exchanger;

public class T12_TestExchanger {
    // 交换器
    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(() -> {
            String s = "T1";
            try {
                // 两个线程都达到这里，该线程要交换 T1，交换后 s 变成 T2
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);
        }, "t1").start();

        new Thread(() -> {
            String s = "T2";
            try {
                // 两个线程都达到这里，该线程要交换 T2，交换后 s 变成 T1
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t2").start();
    }
}
