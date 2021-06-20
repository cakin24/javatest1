package com.mashibing.juc.c_001;

public class T {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        // 任何线程要执行下面的代码，必须先拿到 o 的锁，只有拿到 o 这把锁，才能执行下面这段代码。
        // 一旦 A 线程拿到这把锁，B 线程只有等 A 线程执行完，释放了 o 这把锁，B 再获取这把锁，B 线程才能执行。
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}

