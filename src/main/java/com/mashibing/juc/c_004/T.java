

package com.mashibing.juc.c_004;

public class T {
    private static int count = 10;

    public synchronized static void m() { // 这里等同于 synchronized(T.class)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void mm() {
        synchronized (T.class) { // 这里不能写成 synchronized(this)
            count--;
        }
    }
}
