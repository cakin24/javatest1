package com.itheima.pattern.visitor.dispatch.doubleDispatch;

public class Animal {
    public void accept(Execute exe) {
        exe.execute(this);
    }
}
