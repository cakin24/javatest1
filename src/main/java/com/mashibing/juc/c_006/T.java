package com.mashibing.juc.c_006;

public class T implements Runnable {
    private int count = 10;

    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            T t = new T(); // 注意：这里5个线程对应T对象是不同的，所以并不能锁住
            new Thread(t, "THREAD" + i).start();
        }
    }
}
