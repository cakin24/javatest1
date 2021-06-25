/**
 * ReentrantLock还可以指定为公平锁
 */
package com.mashibing.juc.c_020;

import java.util.concurrent.locks.ReentrantLock;

public class T05_ReentrantLock5 extends Thread {
    // 参数为 true 表示为公平锁，不带参数时，为 false，表示非公平锁，请对比输出结果，
    private static ReentrantLock lock = new ReentrantLock();

    public void run() {
        for (int i = 0; i < 1000; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T05_ReentrantLock5 rl = new T05_ReentrantLock5();
        Thread th1 = new Thread(rl);
        Thread th2 = new Thread(rl);
        th1.start();
        th2.start();
    }
}
