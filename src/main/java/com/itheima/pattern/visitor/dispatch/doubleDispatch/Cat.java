package com.itheima.pattern.visitor.dispatch.doubleDispatch;

public class Cat extends Animal {
    public void accept(Execute exe) {
        exe.execute(this);
    }
}
