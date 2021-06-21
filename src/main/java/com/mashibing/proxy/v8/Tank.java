package com.mashibing.proxy.v8;

import sun.rmi.log.LogHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class Tank implements Movable{
    @Override
    public void move() {
        System.out.println("Tank moving calaclacla...");
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
                new TimeProxy(tank)
        );
        m.move();
    }
}

class TimeProxy implements InvocationHandler{

    Movable m;

    public TimeProxy(Movable m){
        this.m = m;
    }

    private void before(){
        System.out.println("method start");
    }

    private void after(){
        System.out.println("method end");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(m, args);
        after();
        return o;
    }
}

interface Movable{
    void move();
}