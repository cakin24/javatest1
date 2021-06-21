package com.mashibing.proxy.v1;

import java.util.Random;

/**
 * @author: Yuanzt
 * @Date: 2021/3/16
 */
public class Tank implements Move {

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
        new Tank().move();
    }
}

interface Move{
    void move();
}
