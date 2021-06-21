package com.mashibing.proxy.v3;

import java.util.Random;

/**
 * 没有Tank源码时记录程序执行时间
 * 写代码的时候应该慎用继承，因为代码耦合度太高
 * @author: Yuanzt
 * @Date: 2021/3/16
 */
public class Tank implements Move{
    @Override
    public void move() {
        System.out.println("Tank moving calalacala...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new com.mashibing.proxy.v2.Tank().move();
    }
}

class Tank2 extends Tank{
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

interface Move{
    void move();
}