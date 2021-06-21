package com.mashibing.proxy.v4;

import java.util.Random;

/**
 * 模拟在没有源码的情况下，记录move方法的运行时间
 * 使用代理模式处理
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
        new TankTimeProxy(new Tank()).move();
    }
}

/*聚合一辆坦克*/
class TankTimeProxy implements Movable{
    Tank tank;

    public TankTimeProxy(Tank tank){
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

interface Movable{
    void move();
}
