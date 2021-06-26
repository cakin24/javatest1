package com.mashibing.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T13_TestLockSupport {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    LockSupport.park(); // 当前线程停（阻塞）在这里，当其他位置执行 LockSupport.unpark(t); 时，当前线程继续往下跑
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

//        // 版本一：不等待8秒,调用 unpark()
//        // t 线程即使有 park，t 线程也不会阻塞，还是放行
//        LockSupport.unpark(t);

        // 版本二：等待8秒，调用 unpark()
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 8 senconds!");
        // t 线程，别停（阻塞）了，可以走了
        LockSupport.unpark(t);
    }
}
