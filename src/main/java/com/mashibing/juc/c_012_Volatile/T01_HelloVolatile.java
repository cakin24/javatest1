/**
 * volatile 关键字，使一个变量在多个线程间可见
 * A B线程都用到一个变量，java 默认是 A 线程中保留一份 copy，这样如果 B 线程修改了该变量，则 A 线程未必知道
 * 使用 volatile 关键字，会让所有线程都会读到变量的修改值
 * <p>
 * 在下面的代码中，running 是存在于堆内存的 t 对象中
 * 当线程 t1 开始运行的时候，会把 running 值从堆内存中读到 t1 线程的工作区，在运行过程中直接使用这个 copy，并不会每次都去
 * 读取堆内存，这样，当主线程修改 running 的值之后，t1 线程感知不到，所以不会停止运行
 * <p>
 * 使用 volatile ，将会强制所有线程都去堆内存中读取 running 的值
 * <p>
 * 可以阅读这篇文章进行更深入的理解
 * http://www.cnblogs.com/nexiyi/p/java_memory_model_and_thread.html
 * <p>
 * volatile 并不能保证多个线程共同修改 running 变量时所带来的不一致问题，也就是说 volatile 不能替代 synchronized
 */
package com.mashibing.juc.c_012_Volatile;

import java.util.concurrent.TimeUnit;

public class T01_HelloVolatile {
    /*volatile*/ boolean running = true; // 对比一下有无 volatile 的情况下，整个程序运行结果的区别

    void m() {
        System.out.println("m start");
        while (running) {
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}


