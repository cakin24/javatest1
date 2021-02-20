package com.itheima.pattern.mediator;

/**
 * @version v1.0
 * @ClassName: Mediator
 * @Description: 抽象中介者类
 * @Author: cakin
 */
public abstract class Mediator {
    // 申明一个联络方法
    public abstract void constact(String message,Person person);
}
