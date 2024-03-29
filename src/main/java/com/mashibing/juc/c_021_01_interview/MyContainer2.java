/**
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * <p>
 * 使用wait和notify/notifyAll来实现
 * <p>
 * 使用Lock和Condition来实现
 * 对比两种方式，Condition的方式可以更加精确的指定哪些线程被唤醒
 *
 * @author mashibing
 */
package com.mashibing.juc.c_021_01_interview;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer2<T> {
    // 记下的是生产者线程和它生产的产品
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10; // 最多10个元素
    private int count = 0;

    private Lock lock = new ReentrantLock();
    // 能精确叫醒一组线程，newCondition 会产生一个等待队列，队列中是生产者
    private Condition producer = lock.newCondition();
    // newCondition 会产生一个等待队列，队列中是消费
    private Condition consumer = lock.newCondition();

    // 生产
    public void put(T t) {
        try {
            lock.lock();
            while (lists.size() == MAX) { // 想想为什么用while而不是用if？
                producer.await();
            }
            lists.add(t);
            ++count;
            consumer.signalAll(); // 通知消费者线程进行消费，不叫醒生产者
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 消费
    public T get() {
        T t = null;
        try {
            lock.lock();
            while (lists.size() == 0) {
                consumer.await();
            }
            t = lists.removeFirst();
            count--;
            producer.signalAll(); // 通知生产者进行生产，不叫醒消费者
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyContainer2<String> c = new MyContainer2<>();
        //启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) System.out.println(c.get());
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) c.put(Thread.currentThread().getName() + " " + j);
            }, "p" + i).start();
        }
    }
}
