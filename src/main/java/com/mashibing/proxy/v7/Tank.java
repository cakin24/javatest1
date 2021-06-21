package com.mashibing.proxy.v7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 动态代理
 *
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
        Tank tank = new Tank();
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new LogHandler(tank)
        );
        m.move();
    }
}

class LogHandler implements InvocationHandler {
    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method :" + method.getName() + " start...");
        Object o = method.invoke(tank, args);
        System.out.println("method :" + method.getName() + " end");
        return o;
    }
}


interface Movable {
    void move();
}