package com.mashibing.observer.v8;

import java.awt.*;
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

        //小孩醒了之后产生事件
        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(),"bed",this);

        //把事件传给所有的观察者让他们处理
        for (Observer o : observers){
            o.actionOnWakeUp(event);
        }
    }
}

abstract class Event<T>{
    abstract T getSource();
}

class WakeUpEvent extends Event<Child>{
    long timestamp;
    String loc;
    Child source;

    public WakeUpEvent(long timestamp, String loc, Child source){
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}

interface Observer{
    void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements Observer {

    public void feed(){
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer {
    public void hug(){
        System.out.println("mum huging...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer {
    public void wang(){
        System.out.println("dog wanging...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        wang();
    }
}
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
