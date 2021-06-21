package com.mashibing.abstractfactory;

/**
 * @author: Yuanzt
 * @Date: 2021/3/9
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Mushroom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
