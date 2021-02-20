package com.itheima.pattern.visitor.dispatch.dynamicDispatch;

public class Dog extends Animal {
    @Override
    public void execute() {
        System.out.println("dog");
    }
}
