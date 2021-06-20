
/**
 * @className: Account
 * @description: 面试题：模拟银行账户
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 这样实现容易产生脏读问题
 * @date: 2021/6/20
 */
package com.mashibing.juc.c_008;

import java.util.concurrent.TimeUnit;

public class Account {
    String name;
    double balance;
    // 对业务写方法加锁
    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }
    // 对业务读方法不加锁
    public /*synchronized*/ double getBalance(String name) { // 只有在这里加锁，才不会产生脏读问题
        return this.balance;
    }

    public static void main(String[] args) {
        Account a = new Account();
        new Thread(() -> a.set("zhangsan", 100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));
    }
}
