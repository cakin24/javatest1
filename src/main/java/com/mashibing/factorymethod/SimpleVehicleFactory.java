package com.mashibing.factorymethod;

/**
 * 简单工厂模式，可扩展性不好
 * @author: Yuanzt
 * @Date: 2021/3/9
 */
public class SimpleVehicleFactory {

    public Car createCar(){
        return new Car();
    }

    public Broom createBroom(){
        return new Broom();
    }
}
