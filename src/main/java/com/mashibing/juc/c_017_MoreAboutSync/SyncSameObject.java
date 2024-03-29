/**
 * 锁定某对象 o，如果 o 的属性发生改变，不影响锁的使用
 * 但是如果 o 变成另外一个对象，则锁定的对象发生改变
 * 应该避免将锁定对象的引用变成另外的对象
 */
package com.mashibing.juc.c_017_MoreAboutSync;

import java.util.concurrent.TimeUnit;


public class SyncSameObject {

    /*final*/ Object o = new Object(); // 这里应该加上 final，保证该对象不被改写

    void m() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        SyncSameObject t = new SyncSameObject();
        // 启动第一个线程
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 创建第二个线程
        Thread t2 = new Thread(t::m, "t2");
        t.o = new Object(); // 锁对象发生改变，所以 t2 线程得以执行，如果注释掉这句话，线程2将永远得不到执行机会
        t2.start();
    }
}
