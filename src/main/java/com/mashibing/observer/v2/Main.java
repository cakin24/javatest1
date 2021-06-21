package com.mashibing.observer.v2;

/**
 * @author: Yuanzt
 * @Date: 2021/3/15
 */

class Child{
    private boolean cry = false;

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        System.out.println("waked up! crying wuwuwuwuwuwu...");
        cry = true;
    }

}

public class Main {

    public static void main(String[] args) {
        Child child = new Child();
        while (!child.isCry()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observering...");
        }
    }
}
