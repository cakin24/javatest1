package com.mashibing.proxy.v2;

import java.util.Random;

/**
 * @author: Yuanzt
 * @Date: 2021/3/16
 */
public class Tank implements Move {

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("Tank moving calalacala...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}

interface Move{
    void move();
}
