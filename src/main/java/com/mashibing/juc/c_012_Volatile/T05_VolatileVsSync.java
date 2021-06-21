/**
 * volatile 并不能保证多个线程共同修改 count 变量时所带来的不一致问题，也就是说 volatile 不能替代 synchronized
 * 可以用 synchronized 解决，synchronized 可以保证可见性和原子性，volatile 只能保证可见性
 * count++ 并不是原子指令
 */
package com.mashibing.juc.c_012_Volatile;

import java.util.ArrayList;
import java.util.List;


public class T05_VolatileVsSync {
    /*volatile*/ int count = 0; // 位置1

    synchronized void m() { // 位置2：这里一定要用 synchronized
        for (int i = 0; i < 10000; i++)
            count++;
    }

    public static void main(String[] args) {
        T05_VolatileVsSync t = new T05_VolatileVsSync();
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }
        threads.forEach((o) -> o.start());
        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
