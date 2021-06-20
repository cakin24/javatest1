/**
 * @className: T
 * @description: 父子类相同方法是可重入加锁
 * @date: 2021/6/20
 * @author: 贝医
 */
package com.mashibing.juc.c_010;

import java.util.concurrent.TimeUnit;

public class T {
    // 父类 m 方法是对 TT 对象加锁，是可重入锁
    synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}

class TT extends T {
    // 子类 m 方法是对 TT 对象加锁
    @Override
    synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
