package com.mashibing.juc.c_003;

public class T {
    private int count = 10;
    public synchronized void m() { // 等同于在方法代码执行时加 synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
