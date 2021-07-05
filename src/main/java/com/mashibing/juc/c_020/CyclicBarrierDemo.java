package com.mashibing.juc.c_020;

import java.util.concurrent.CyclicBarrier;

// 从打印结果可以看出，所有线程会等待全部线程到达栅栏之后才会继续执行，并且最后到达的线程会完成 Runnable 的任务。
// 场景：有3个任务，一个是读数据库，一个是读文件，一个是读网络，先串行操作，再将读到的所有数据进行拼接，这样做效率比较低。
// 如果采用 CyclicBarrier ，让3个任务变成3个线程，让他们并行完成各自的任务，当等到这3个任务都完成后，冲破栅栏，再组织数据，效率将大幅提高。
public class CyclicBarrierDemo {
    static class TaskThread extends Thread {
        CyclicBarrier barrier;
        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + " 到达栅栏 A");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 A");

                Thread.sleep(2000);
                System.out.println(getName() + " 到达栅栏 B");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 完成最后任务");
            }
        });

        for(int i = 0; i < threadNum; i++) {
            new TaskThread(barrier).start();
        }
    }
}
