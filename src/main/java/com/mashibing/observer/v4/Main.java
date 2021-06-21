package com.mashibing.observer.v4;

/**
 * @author: Yuanzt
 * @Date: 2021/3/15
 */
class Child{

    private boolean cry = false;
    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        dad.feed();
        dog.wang();
        mum.hug();
    }
}
class Dad{
    public void feed(){
        System.out.println("dad feeding...");
    }
}
class Dog{
    public void wang(){
        System.out.println("dog wanging...");
    }
}
class Mum{
    public void hug(){
        System.out.println("mum huging...");
    }
}
public class Main {

    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }
}
