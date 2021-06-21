package com.mashibing.templateMethod;

/**
 * 模板方法模式
 * @author: Yuanzt
 * @Date: 2021/3/19
 */
public class Main {
    public static void main(String[] args) {
        F f = new C();
        f.m();
    }
}

abstract class F{
    void m(){
        op1();
        op2();
    }

    abstract void op1();
    abstract void op2();
}

class C extends F{
    @Override
    void op1() {
        System.out.println("c's op1");
    }

    @Override
    void op2() {
        System.out.println("c's op2");
    }
}
