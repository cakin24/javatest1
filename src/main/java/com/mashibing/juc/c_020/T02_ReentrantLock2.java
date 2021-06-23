/**
 * 使用 reentrantlock 可以完成同样的功能
 * 需要注意的是，必须要必须要必须要手动释放锁（重要的事情说三遍）
 * 使用 synchronized 锁定的话如果遇到异常，jvm会自动释放锁，但是 lock 必须手动释放锁，因此经常在 finally 中进行锁的释放
 */
package com.mashibing.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T02_ReentrantLock2 {
    // 不同的线程争用同一把锁，会出现竞争
    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock(); // 类似 synchronized(this)
            System.out.println(this); // 其实是锁 this 对象，它是 T02_ReentrantLock2 的一个对象
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // 一定要解锁，否则会发生死锁
        }
    }

    void m2() {
        try {
            lock.lock();
            System.out.println(this); // 其实是锁 this 对象,它是 T02_ReentrantLock2 的一个对象
            System.out.println("m2 ...");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        T02_ReentrantLock2 rl = new T02_ReentrantLock2();
        // 线程1 使用 lock 这把锁
        new Thread(rl::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 线程2 使用 lock 这把锁
        new Thread(rl::m2).start();
    }
}
