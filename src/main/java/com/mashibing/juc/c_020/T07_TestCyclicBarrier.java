package com.mashibing.juc.c_020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// 它的作用就是会让所有线程都等待完成后才会继续下一步行动。
// 场景：一个线程组的线程需要等待所有线程完成任务后再继续执行下一次任务
public class T07_TestCyclicBarrier {
    public static void main(String[] args) {
        // 第一种方式
        // CyclicBarrier barrier = new CyclicBarrier(20);
        // 第二种方式
        // 循环栅栏，满了20，调用第2个参数指定的代码
        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("满人，发车"));
        // 第三种方式
        /*CyclicBarrier barrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("满人，发车");
            }
        });*/

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
