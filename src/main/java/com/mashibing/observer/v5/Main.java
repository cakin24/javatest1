package com.mashibing.observer.v5;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Yuanzt
 * @Date: 2021/3/15
 */
class Child{
    private boolean cry = false;
    private List<Observer> observers = new LinkedList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean cry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        for (Observer o : observers){
            o.actionOnWakeUp();
        }
    }
}

interface Observer{
    void actionOnWakeUp();
}

class Dad implements Observer{

    public void feed(){
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp() {
        feed();
    }
}

class Mum implements Observer{
    public void hug(){
        System.out.println("mum huging...");
    }

    @Override
    public void actionOnWakeUp() {
        hug();
    }
}

class Dog implements Observer{
    public void wang(){
        System.out.println("dog wanging...");
    }

    @Override
    public void actionOnWakeUp() {
        wang();
    }
}

public class Main {

    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
