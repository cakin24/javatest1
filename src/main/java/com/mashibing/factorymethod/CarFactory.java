package com.mashibing.factorymethod;

/**
 * @author: Yuanzt
 * @Date: 2021/3/9
 */
public class CarFactory {

    public Moveable create(){
        System.out.println("A car created");
        return new Car();
    }
}
