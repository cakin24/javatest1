package com.mashibing.proxy.v6;

import java.util.Random;

/**
 * 静态代理
 * @author: Yuanzt
 * @Date: 2021/3/16
 */
public class Tank implements Movable{
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
        new TankLogProxy( new TankTimeProxy(new Tank())).move();
    }
}

class TankTimeProxy implements Movable{
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Movable{
    Movable m;

    public TankLogProxy(Movable m){
        this.m = m;
    }
    @Override
    public void move() {
        System.out.println("tank start move");
        m.move();
        System.out.println("tank end move");
    }
}

interface Movable{
    void move();
}