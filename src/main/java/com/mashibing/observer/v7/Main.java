package com.mashibing.observer.v7;


import java.util.LinkedList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理
 * 大多是时候，我们处理事件的时候，需要事件源对象
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
//事件本身，事件与观察者本身的耦合度很低
class WakeUpEvent{
    long timestamp;
    String loc;
    Child source;

    public WakeUpEvent(long timestamp,String loc,Child source){
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
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
