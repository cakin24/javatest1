package com.mashibing.abstractfactory;

/**
 * @author: Yuanzt
 * @Date: 2021/3/9
 */
public abstract class AbstractFactory {

    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();

}
