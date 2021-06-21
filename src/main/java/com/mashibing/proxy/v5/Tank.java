package com.mashibing.proxy.v5;

import java.util.Random;

/**
 * @author: Yuanzt
 * @Date: 2021/3/16
 */
public class Tank implements Movable {
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
        new TankTimeProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Movable{

    Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Movable{

    Tank tank;

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }
    @Override
    public void move() {
        System.out.println("tank start move");
        tank.move();
        System.out.println("tank end move");
    }
}

interface Movable{
    void move();
}
