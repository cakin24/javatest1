package com.mashibing.juc.c_000;

// 创建和启动线程
public class T02_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    public static void main(String[] args) {
        new MyThread().start(); // 通过继承 Thread 创建和启动线程
        new Thread(new MyRun()).start(); // 通过实现 Runnable 创建和启动线程
        new Thread(() -> {
            System.out.println("Hello Lambda!");
        }).start(); // 通过 Lambda 表达式创建和启动线程，它实际是第2种的变形
    }
}
// 启动线程的三种方式
// 1：Thread
// 2：Runnable
// 3：Executors.newCachedThread 通过线程池启动线程
