/**
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 * <p>
 * 给lists添加volatile之后，t2能够接到通知，但是，t2线程的死循环很浪费cpu，如果不用死循环，该怎么做呢？
 * <p>
 * 这里使用 wait 和 notify 做到，wait 会释放锁，而 notify 不会释放锁
 * 需要注意的是，运用这种方法，必须要保证 t2 先执行，也就是首先让 t2 监听才可以
 * <p>
 * 阅读下面的程序，并分析输出结果
 * 可以读到 输出结果并不是size=5时t2退出，而是 t1 结束时 t2 才接收到通知而退出
 * 想想这是为什么？
 *
 * @author mashibing
 */
package com.mashibing.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class T03_NotifyHoldingLock { // wait notify
    // 添加 volatile，使 t2 能够得到通知
    volatile List lists = new ArrayList();
    public void add(Object o) {
        lists.add(o);
    }
    public int size() {
        return lists.size();
    }
    public static void main(String[] args) {
        T03_NotifyHoldingLock c = new T03_NotifyHoldingLock();

        final Object lock = new Object();
        // 先启动 t2
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2启动");
                if (c.size() != 5) {
                    try {
                        lock.wait(); // 等待，被唤醒后，还必须得到锁。被唤醒和得到锁两个条件必须同时满足。
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
            }
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        // 再启动 t1
        new Thread(() -> {
            System.out.println("t1启动");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);
                    if (c.size() == 5) {
                        lock.notify(); // 唤醒 t2，但不释放锁
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();
    }
}
