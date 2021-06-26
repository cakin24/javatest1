package com.mashibing.juc.c_020;

import java.util.concurrent.Semaphore;

public class T11_TestSemaphore {
    public static void main(String[] args) {
        // 作用：限流
        // 两个可以同时执行
        // Semaphore s = new Semaphore(2);
        // 第2个参数代表是否是公平锁
        Semaphore s = new Semaphore(2, true);
        // 允许一个线程同时执行
        // Semaphore s = new Semaphore(1);
        new Thread(() -> {
            try {
                // 当为1，可以获得信号量，否则等待
                s.acquire();
                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

        new Thread(() -> {
            try {
                // 当为1，可以获得信号量，否则等待
                s.acquire();
                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");
                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
