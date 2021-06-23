/**
 * reentrantlock 用于替代 synchronized
 * 本例中由于 m1 锁定 this,只有 m1 执行完毕的时候,m2 才能执行
 *
 * @author mashibing
 */
package com.mashibing.juc.c_020;

import java.util.concurrent.TimeUnit;

public class T01_ReentrantLock1 {
    // m1 锁的是 this 对象
    synchronized void m1() {
        System.out.println(this);
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            // 针对同一线程，m2 可重入
            if (i == 2) m2();
        }
    }

    // m2 锁的也是 this 对象
    synchronized void m2() {
        System.out.println(this);
        System.out.println("m2 ...");
    }

    public static void main(String[] args) {
        T01_ReentrantLock1 rl = new T01_ReentrantLock1();
        new Thread(rl::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // new Thread(rl::m2).start(); // 如果是两个线程，对 this 同一把锁是有争用的，不可重入。
    }
}
