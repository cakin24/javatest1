package com.mashibing.abstractfactory;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author: Yuanzt
 * @Date: 2021/3/9
 */
public class Main {

    public static void main(String[] args) {
       AbstractFactory af = new MagicFactory();
        Food food = af.createFood();
        food.printName();
        Vehicle vehicle = af.createVehicle();
        vehicle.go();
        Weapon weapon = af.createWeapon();
        weapon.shoot();
    }

}
