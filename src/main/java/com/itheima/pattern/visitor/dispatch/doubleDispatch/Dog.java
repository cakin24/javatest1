package com.itheima.pattern.visitor.dispatch.doubleDispatch;

public class Dog extends Animal {
    public void accept(Execute exe) {
        exe.execute(this);
    }
}
