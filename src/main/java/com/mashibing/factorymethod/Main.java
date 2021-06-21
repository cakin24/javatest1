package com.mashibing.factorymethod;

/**
 * @author: Yuanzt
 * @Date: 2021/3/9
 */
public class Main {

    public static void main(String[] args) {
//        Car car = new Car();
//        car.go();
//        Moveable m = new Broom();
//        m.go();
        Moveable m = new CarFactory().create();
        m.go();
    }

}
