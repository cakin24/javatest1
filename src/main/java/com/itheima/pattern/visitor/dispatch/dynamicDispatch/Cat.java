package com.itheima.pattern.visitor.dispatch.dynamicDispatch;

public class Cat extends Animal {
    @Override
    public void execute() {
        System.out.println("cat");
    }
}
