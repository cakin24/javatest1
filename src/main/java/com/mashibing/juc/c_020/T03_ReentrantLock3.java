/**
 * 使用 reentrantlock 可以进行“尝试锁定” tryLock，这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 */
package com.mashibing.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T03_ReentrantLock3 {
    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock();
            for (int i = 0; i < 3 /*3*/; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 使用 tryLock 进行尝试锁定，不管锁定与否，方法都将继续执行
     * 可以根据 tryLock 的返回值来判定是否锁定
     * 也可以指定 tryLock 的时间，由于 tryLock(time)抛出异常，所以要注意 unclock 的处理，必须放到 finally 中
     */
    void m2() {
		/*
		boolean locked = lock.tryLock();
		System.out.println("m2 ..." + locked);
		if(locked) lock.unlock();
		*/
        boolean locked = false;
        try {
            locked = lock.tryLock(5, TimeUnit.SECONDS);
            if(locked == true){
                System.out.println("拿到锁的处理逻辑"); // 当等 3 秒，走该逻辑
            } else {
                System.out.println("没拿到锁的处理逻辑"); // 当等 10 秒，走该逻辑
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked) lock.unlock();
        }
    }

    public static void main(String[] args) {
        T03_ReentrantLock3 rl = new T03_ReentrantLock3();
        new Thread(rl::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(rl::m2).start();
    }
}
