package com.itheima.pattern.visitor.dispatch.dynamicDispatch;

public class Client {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.execute();

        Animal a1 = new Cat();
        a1.execute();
    }
}
